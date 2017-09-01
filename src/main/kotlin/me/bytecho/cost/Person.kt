package me.bytecho.cost

/**
 *
 * Created by Alan on 2017/9/1.
 */
class Person(val name: String = "Alan", var age: Int = 0, val id: Long = -1) {
    init {
        println("$name")
    }
}