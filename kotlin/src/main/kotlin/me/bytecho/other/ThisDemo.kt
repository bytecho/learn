package me.bytecho.other

/**
 * Created by Alan Wang on 2017-3-20.
 */

/*
* this keyword:
* ---in class, present of current object of the class
* ---in a extension function or function literal with receiver,
* this denotes the receiver parameter that is passed on the left-
* hand side of a dot.
* ---if this has no qualifiers, it refers to the innermost enclosing scope
. To refer to this in other scopes, label qualifiers are used。
* */

fun main(args: Array<String>) {
    val a = TestThisA().B().test()
}

class TestThisA {
    val af = 233

    inner class B {
        val bf = 666

        fun Int.foo() {
            val a = this@TestThisA.af
            val b = this@B.bf
            val c = this
            val d = this@foo

            val funSum = lambada@ fun Int.(): Int {
                val f = this
                println(f)
                return a + b + c + d
            }

            println("a is $a, b is $b, c is $c , d is $d, 3.funSum is ${3.funSum()}")
        }

        fun test() {
            3.foo()
        }
    }
}