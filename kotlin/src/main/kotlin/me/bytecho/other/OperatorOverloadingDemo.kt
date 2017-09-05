package me.bytecho.other

import me.bytecho.Utils

/**
 *
 * Created by Alan on 2017/4/20.
 */

fun main(args: Array<String>) {
    var a: OperatorOverloadingDemo = OperatorOverloadingDemo()
    val b: OperatorOverloadingDemo = OperatorOverloadingDemo()

    //Unary operations
    Utils.prtRightCutTag("Unary operations")
    +a
    -a
    !a
    --a
    ++a
    a++ //same as ++a
    a-- // same as --a

    //Binary operations
    Utils.prtLeftCutTag("Binary operations")
    a + b
    a - b
    a * b
    a / b
    a % b
    a..b

    //for table class
    a in b
    a !in b // equals !a.contains(b)

    //Square brackets are translated to calls to get and set
    // with appropriate numbers of arguments
    val i = 0
    val j = 0
    a[i]
    a[i, j]
    a[i] = b
    a[i, j] = b

    //Parentheses are translated to calls to invoke
    // with appropriate number of arguments
    a()
    a(i)

    //assignment operations
    /*  a += b  //may conflict with a + b  Note: assignments are NOT expressions in Kotlin.
      a /= b*/

    //comparison operations
    Utils.prtRightCutTag("comparison operations")
    a > b // comparison operations convert to fun compareTo
}

class OperatorOverloadingDemo {
    private fun prt(funName: String, operator: String) {
        println("$funName overload operator [$operator]")
    }

    private fun prt(funName: String, operator: String, mark: String) {
        println("$funName overload operator [$operator], mark: $mark")
    }

    operator fun unaryPlus() {
        prt("unaryPlus", "+a")
    }

    operator fun unaryMinus() {
        prt("unaryMinus", "-a")
    }

    operator fun not() {
        prt("unaryMinus", "!a")
    }

    operator fun dec(): OperatorOverloadingDemo {
        prt("dec", "--a")
        return this
    }

    operator fun inc(): OperatorOverloadingDemo {
        prt("inc", "++a")
        return this
    }

    operator fun plus(a: OperatorOverloadingDemo) {
        prt("plus", "a + b")
    }

    operator fun minus(a: OperatorOverloadingDemo) {
        prt("minus", "a - b")
    }

    operator fun times(a: OperatorOverloadingDemo) {
        prt("times", "a * b")
    }

    operator fun div(a: OperatorOverloadingDemo) {
        prt("div", "a / b")
    }

    operator fun rem(a: OperatorOverloadingDemo) {
        prt("rem", "a % b")
    }

    operator fun rangeTo(a: OperatorOverloadingDemo) {
        prt("rangeTo", "a..b")
    }

    operator fun contains(a: OperatorOverloadingDemo): Boolean {
        prt("contains", "a in b", "for table class as below")
        return false
    }

    operator fun get(i: Int) {
        prt("rangeTo", "a[i]")
    }

    operator fun get(i: Int, j: Int) {
        prt("get", "a[i,j]")
    }

    operator fun set(i: Int, value: OperatorOverloadingDemo) {
        prt("set", "a[i] = b")
    }

    operator fun set(i: Int, j: Int, value: OperatorOverloadingDemo) {
        prt("set", "a[i,j]=b")
    }

    operator fun invoke() {
        prt("invoke", "a()")
    }

    operator fun invoke(i: Int) {
        prt("invoke", "a(i)")
    }

    operator fun plusAssign(b: OperatorOverloadingDemo) {
        prt("plusAssign", "a += b")
    }

    operator fun compareTo(b: OperatorOverloadingDemo): Int {
        prt("compareTo", "a += b")
        return 1;
    }
}