package me.bytecho.other

/**
 *
 * Created by Alan on 2017/2/23.
 */

fun main(args: Array<String>) {

    val i: Int = 1
    val range = i.rangeTo(10)
    println("range: first is ${range.first}, last is ${range.last}, step is ${range.step}")
    println(range.step(5).step)

    val j: Int = 3
    val message = j.downTo(-10)
    println("${message.first}   ${message.last}  ${message.step}")
    val reversed = message.reversed()
    println("${reversed.first}   ${reversed.last}  ${reversed.step}")
}