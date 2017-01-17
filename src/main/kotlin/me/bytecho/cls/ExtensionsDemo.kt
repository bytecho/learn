package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/16.
 */

/*Most of the time we define extensions on the top level*/
fun main(args: Array<String>) {
    val ea: EA = EA(1, 2)
    ea.minus()
    ea.add()

    println("EA.toString: " + ea.toString())

    var ea2: EA? = null
    println("EA?.toString: " + ea2.toString())

    var ea3: EA? = EA(2, 3)
    println("EA?.toString: " + ea3.toString())

    println("ea.i3 is ${ea.i3}")

    EA2.foo()

    val ea33: EA3 = EA3()
    ea33.testExtensionMember(ea)
}

//begin
class EA {
    var i1: Int = 0;
    var i2: Int = 0;

    constructor()
    constructor(i1: Int, i2: Int) {
        this.i1 = i1
        this.i2 = i2
    }

    fun add() {
        println("sum of i1 + i2 is ${i1 + i2}")
    }
}

//Extension Functions
fun EA.minus() {
    println("i1 - i2 is ${i1 - i2}")
}

//they are not virtual by receiver type. This
//means that the extension function being called is determined by the type of the expression on which the function is invoked,
//not by the type of the result of evaluating that expression at runtime.
//extension fun do not override
fun EA.add() {
    println("override add fun")
}

//Nullable Receiver
fun EA?.toString(): String {
    if (this == null) return "null"

    return this.javaClass.simpleName
}

//Extension Properties
val EA.i3: Int
    get() = i2 + 100

//bad design
var EA.i4: Int
    set(value) {}
    get() = this.i3

//Companion Object Extensions
class EA2 {
    companion object
}

fun EA2.Companion.foo() {
    println(this.javaClass.name + " extension companion obj")
}

//Declaring Extensions as Members
class EA3 {
    fun funOfEA3() {
        System.out.println("EA3.funOfEA3");
    }

    fun EA.funAsMember() {
        println("--------------------")
        minus()
        funOfEA3()
        println("--------------------")
    }

    fun EA.toString() {
        toString()
        this@EA3.toString()
    }

    fun testExtensionMember(ea: EA) {
        ea.funAsMember()
    }
}