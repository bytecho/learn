package me.bytecho.other

import me.bytecho.Utils

/**
 *
 * Created by Alan on 2017/2/22.
 */
fun main(args: Array<String>) {
    firstTest()
    Utils.prtRightCutLine()
    testExtensionFun()
}

/*
 * Kotlin does not have dedicated syntax constructs for creating lists or sets.
 * Use methods from the standard library, such as listOf(), mutableListOf(),
 * setOf(), mutableSetOf()
 * */
fun firstTest() {
    val mutableNumbers: MutableList<Int> = mutableListOf(1, 2, 3)
    mutableNumbers.add(4)
    println("mutableNumbers is $mutableNumbers")

    val immutableNo: List<Int> = listOf(1, 22, 33)
    println("immutableNo is $immutableNo")

    val mapVar: Map<Int, String> = mapOf()
}

fun testExtensionFun() {
    val imList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("first e of imList is ${imList.first()}")
    println("last e of imList is ${imList.last()}")
    println(imList.filter { it % 2 == 0 })

    val muList: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(muList.none { it -> it == -1 })
}