package me.bytecho.coroutines

import kotlinx.coroutines.experimental.*
import kotlin.system.measureTimeMillis

/**
 *
 * Created by Alan on 2017/6/22.
 */

fun main(args: Array<String>) {
//    testLaunch4()
//    testJobCancel()
//    testNonCancellableJob()
//    testAwait()
//    testAsyncFunc()
//    testDispatcher()
//    debugCoroutines()
//    jumpBetweenThreads()
    testChildOfCoroutine()
}

fun testLaunch() {
    launch(CommonPool) {
        delay(1000)
        println("delayed --------------> hello world0")
    }

    launch(CommonPool) {
        delay(1000 * 5)
        println("delayed ---------------> hello world1")
    }

    for (i in 1..64) {
        Thread.sleep(100)
        println("tick ${i}")
    }
}

fun testLaunch2() {
    //should used in main thread
    runBlocking {
        launch(CommonPool) {
            delay(1000)
            println("delayed --------------> hello world2")
        }

        for (i in 1..64) {
            delay(200)
            println("tick2 ${i}")
        }
    }
}

fun testLaunch3() {
    runBlocking {
        val job = launch(CommonPool) {
            delayPrt("delayed --------------> hello world3")
        }

        val job2 = launch(CommonPool) {
            delayPrt("delayed --------------> hello world3-1")
        }

        for (i in 1..64) {
            delay(200)
            println("tick3 ${i}")
        }

        job.join()
        job2.join()
    }
}

fun testLaunch4() {
    runBlocking {
        val jobs = List(1000_000) {
            launch(CommonPool) {
                delayPrt(it * 100L, "delayed --------------> hello world $it")
            }
        }

        jobs.forEach { it.join() }
    }

    /*runBlocking {
        val list = List(100_000) {
            delayPrt(100, "delayed --------------> hello world $it")
        }
    }*/

    /*  val list = ArrayList<Thread>()
      for (i in 0..100_000) {
          val t = Thread({
              Thread.sleep(i * 100L)
              println("delayed --------------> hello world $i")
          }, "pid_$i")
          list.add(t)
      }

      list.forEach { it.start() }*/
}


fun testJobCancel() {
    runBlocking {
        val job = launch(CommonPool) {
            var nextPrintTime = 0L
            var i = 0
            while (isActive) { // computation loop
                val currentTime = System.currentTimeMillis()
                if (currentTime >= nextPrintTime) {
                    println("I'm sleeping ${i++} ...")
                    nextPrintTime = currentTime + 500L
                }
            }
        }
        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancel() // cancels the job
        delay(1300L) // delay a bit to see if it was cancelled....
        println("main: Now I can quit.")
    }
}

fun testNonCancellableJob() = runBlocking {
    val job = launch(CommonPool) {
        try {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            run(NonCancellable) {
                println("I'm running finally")
                delay(1000L)
                println("And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    delay(1300L) // delay a bit to ensure it was cancelled indeed
    println("main: Now I can quit.")
}


fun testAwait() = runBlocking {
    val time = measureTimeMillis {
        val one = async(CommonPool) { delayPrt(200, "return one");return@async 12 }
        val two = async(CommonPool) { delayPrt(1000 * 2, "return two"); return@async 13 }
        println("one plus two is ${one.await() + two.await()}")
    }
}

fun testAsyncFunc() {

    val time = measureTimeMillis {
        val one = generateOne()
        val two = generateTwo()
        runBlocking {
            println("one plus two is ${one.await() + two.await()}")
        }
    }

    runBlocking {
        for (i in 1..64) {
            delayPrt(100, "tick2 ${i}")
        }
    }

    println("time is ${time}")
}

fun testDispatcher() = runBlocking {
    val jobs = arrayListOf<Job>()
    jobs += launch(Unconfined) {
        // not confined -- will work with main thread
        println(" 'Unconfined': I'm working in thread ${Thread.currentThread().name}")
    }
    jobs += launch(context) {
        // context of the parent, runBlocking coroutine
        println("    'context': I'm working in thread ${Thread.currentThread().name}")
    }
    jobs += launch(CommonPool) {
        // will get dispatched to ForkJoinPool.commonPool (or equivalent)
        println(" 'CommonPool': I'm working in thread ${Thread.currentThread().name}")
    }
    jobs += launch(newSingleThreadContext("MyOwnThread")) {
        // will get its own new thread
        println("     'newSTC': I'm working in thread ${Thread.currentThread().name}")
    }
    jobs.forEach { it.join() }
}

fun debugCoroutines() = runBlocking {
    val a = async(context) {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async(context) {
        log("I'm computing another piece of the answer")
        7
    }
    log("The answer is ${a.await() * b.await()}")
}

fun jumpBetweenThreads() {
    val ctx1 = newSingleThreadContext("ctx1")
    val ctx2 = newSingleThreadContext("ctx2")
    runBlocking(ctx1) {
        log("Started in ctx1")
        run(ctx2) {
            log("Working in ctx2")
        }
        log("Back to ctx1")
    }
}

//share same context
fun testChildOfCoroutine() = runBlocking {
    val request = launch(CommonPool) {
        // it spawns two other jobs, one with its separate context
        val job1 = launch(CommonPool) {
            println("job1: I have my own context and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }
        // and the other inherits the parent context
        val job2 = launch(context) {
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
        // request completes when both its sub-jobs complete:
        job1.join()
        job2.join()
    }
    delay(500)
    request.cancel() // cancel processing of the request
    delay(1000) // delay a second to see what happens
    println("main: Who has survived request cancellation?")
}
//////////////////////////////////////////////////////////////////////////////////////////////

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun generateOne() = async(CommonPool, CoroutineStart.LAZY) {
    delayPrt(1000, "genarate first integer")
    return@async 12
}

fun generateTwo() = async(CommonPool, CoroutineStart.LAZY) {
    delayPrt(2000, "generate second integer")
    return@async 13
}

private suspend fun delayPrt(str: String) {
    delayPrt(1000, str)
}

private suspend fun delayPrt(time: Long, str: String) {
    delay(time)
    println(str)
}