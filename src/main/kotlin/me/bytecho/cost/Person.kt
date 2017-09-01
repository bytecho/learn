package me.bytecho.cost

/**
 *
 * Created by Alan on 2017/9/1.
 */

fun main(args: Array<String>) {
    val p = Person()
    println(p.isAdult())
}
class Person(val name: String = "Alan", var age: Int = 0, val id: Long = -1) {
    init {
        println("$name")
    }

    fun isAdult():Boolean {
        println("from declared fun")
        return age >= 18
    }
}

fun Person.isAdult():Boolean {
    return age >= 18
}