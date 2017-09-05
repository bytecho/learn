package me.bytecho.cost

/**
 *
 * Created by Alan on 2017/8/28.
 */
fun main(args: Array<String>) {

    duration {
        for (i in 0..10) {
            Thread.sleep(100)
        }
    }

    inlineDuration {
        for (i in 0..10) {
            Thread.sleep(100)
        }
    }
}

fun duration(block: () -> Any?) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("func duration is ${end - start}")
}

inline fun inlineDuration(block: () -> Any?) {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    println("func duration is ${end - start}")
}