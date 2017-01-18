package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/17.
 */

fun main(args: Array<String>) {

    first()
}

//first demo
fun first() {
    val arr: Array<String> = arrayOf("a", "b", "c")
    for (s in arr) {
        print(s + "\t")
    }
}

//Declaration-site variance.
// producer out, consumer in
interface Popper<out T> {
    fun pop(): T
}

interface Pusher<in T> {
    fun push(arr: List<T>, e: T)
}

//type projections
