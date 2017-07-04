package me.bytecho.coroutines

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking

/**
 *
 * Created by Alan on 2017/6/22.
 */

fun main(args: Array<String>) {
    testLaunch3()
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

        for (i in 1..64) {
            delay(200)
            println("tick3 ${i}")
        }
    }
}

private suspend fun delayPrt(str: String) {
    delay(1000)
    println(str)
}