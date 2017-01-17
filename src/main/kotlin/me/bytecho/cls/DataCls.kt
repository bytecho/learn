package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/17.
 */

fun main(args: Array<String>) {

    val a1: Account = Account(0, "a@b.com", "123")
    val a2: Account = Account(0, "a@b.com", "123")
    val a3: Account = Account(1, "a@b.com", "123")

    println("data class toSting:------------------------------------")
    println("a1 is ${a1.toString()}")
    println("a2 is ${a2.toString()}")
    println("a3 is ${a3.toString()}")
    println("data class equals:------------------------------------")
    println("a1 equal a2: ${a1.equals(a2)}")
    println("a2 equal a3: ${a2.equals(a3)}")
    println("data class ==:------------------------------------")
    println("a1 == a2: ${a1 == a2}")
    println("a2 == a3: ${a2 == a3}")

    println("data class copy:---------------------------------------")
    val a4 = a1.copy(2)
    println("a4 copied a1 : ${a4}")

}

data class Account(val id: Int, var email: String, val psd: String) {
    fun foo() {}
}

//data class can't extends but may implements
open class SuperData

interface InterData {
    val name: String
    fun foo()
}

//data class Sub: SuperData() ×
data class Sub(var age:Int, override val name: String) : InterData {
    override fun foo() {
        //do nothing
    }
}