package me.bytecho.start

/**
 * Created by Alan Wang on 2017-1-2.
 */

fun main(args: Array<String>) {
    //define fun
    println(add(1, 2))
    println(sum(1, 2))
    println(max(1, 2))

    //define local variables
    //immutable
    val i: Int = 3
    val i2 = 4
    //mutable
    var i3 = 5
    i3 += 5
    println("i=$i i2=$i2 i3=$i3")

    //using string temp
    val s: String = "hello world"
    println("s is $s")
    val arr = arrayOf("hello", "world")
    println("arr[0] is ${arr[0]}")

    //using null check and cast check
    //auto cast
    println(toInt("233"))
    println(toInt(null))
}


fun add(a: Int, b: Int): Int {
    return a + b
}

fun sum(a: Int, b: Int) = a + b

fun max(a: Int, b: Int) = if (a > b) a else b

fun parseInt(s: String): Int? = s.toInt()

fun toInt(s: Any?): Int? {
    if (s != null && s is String) return parseInt(s)
    return null
}