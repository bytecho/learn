package me.bytecho.other

import me.bytecho.Utils
import me.bytecho.cls.Person

/**
 * Created by Alan Wang on 2017-3-20.
 */

/*
* this was two types of equality:
*
* ---reference equality.
* ---structure equality.
*
* */
fun main(args: Array<String>) {
    Utils.prtRightCutTag("Equality")
    testRefEquality()
    Utils.prtLeftCutLine()
    testNullEquality(null, "233")
    testNullEquality(null, null)
    testNullEquality("233", null)
    testNullEquality("233", "233")
}

fun testRefEquality() {
    val a = 233
    val b = 233
    println("a is $a, b is$b, a's ref is ${a.hashCode()}," +
            " b's ref is ${b.hashCode()}, a === b is ${a === b}," +
            " a.equals(b) is ${a.equals(b)}")

    val p1 = Person("alan")
    val p2 = Person("alan")
    println("p1's ref is ${p1.hashCode()}, p2.s ref is ${p2.hashCode()}" +
            " p1 === p2 is ${p1 === p2}, p1.equals(p2) is ${p1.equals(p2)}")
}

fun testNullEquality(a: String?, b: String?) {
    println("${a?.equals(b) ?: (b == null)}")
}