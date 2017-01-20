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

class Arr<T>(val size: Int = 5) {
    val arr: Array<T>? = null
    fun get(i: Int): T {
        return arr?.get(0) as T
    }

    fun add(t: T) {}
}

fun copy(from: Arr<out Any>, to: Arr<Any>) {
    assert(from.size == to.size)
    for (i in 0..from.size) {
        to.add(from.get(i))
    }
}

fun testCopy() {
    val from: Arr<String> = Arr(10);
    val to: Arr<Any> = Arr(10)
    copy(from, to)
}

//TODO wait to review
