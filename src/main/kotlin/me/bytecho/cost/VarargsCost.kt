package me.bytecho.cost

/**
 *
 * Created by Alan on 2017/9/1.
 */

fun main(args: Array<String>) {
//    prtElement("1", "2", "3")

//    prtElement(*arrayOf("1", "2", "3"))
    prtElement(*arrayOf("1", "2", "3"), "4", "5")
}

fun prtElement(vararg list: String) {
    list.forEach { println(it) }
}