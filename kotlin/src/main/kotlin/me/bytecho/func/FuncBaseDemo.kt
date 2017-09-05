package me.bytecho.func

import me.bytecho.Utils
import java.util.*

/**
 *
 * Created by Alan on 2017/2/5.
 */

fun main(args: Array<String>) {
    testInfix()
    Utils.prtRightCutLine()
    testVarargFun()
}

//func declare
fun func(str: String): String {
    return str
}

//infix fun
/*
----They are member functions or extension functions
----They have a single parameter
----They are marked with the infix keyword
*/
infix fun Int.infixFunc(times: Int) {
    println("$this multi $times is ${this * times}")
}

fun testInfix() {
    2 infixFunc 3
}

//Variable number of arguments
fun varargFun(vararg ts: String) {
    val arr: ArrayList<String> = ArrayList()
    for (t in ts) arr.add(t)
    println(arr)
}

fun testVarargFun() {
    varargFun("a ", "b ", "c ")

    // if we already have an array and want to pass its contents to the function, we use the
    // spread operator (prefix the array with *)
    println(">>>include an arr<<<")
    var a = arrayOf("arr1", "arr2", "arr3")
    varargFun("a", "b", "c", *a, "d")
}

