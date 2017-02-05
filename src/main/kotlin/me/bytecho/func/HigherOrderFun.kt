package me.bytecho.func

import java.util.*

/**
 *
 * Created by Alan on 2017/2/5.
 */

fun main(args: Array<String>) {
    testFuncParam()
}

fun concatEach(subFix: String, arr: () -> ArrayList<String>) {
    arr.invoke().forEach { s -> s.plus(subFix) }
    println(arr.invoke())
}

private fun testFuncParam() {
    concatEach("-subFix", {
        val arr: ArrayList<String> = ArrayList()
        for (i in 1..10) {
            arr.add("ele$i")
        }
        return@concatEach arr
    })
}
