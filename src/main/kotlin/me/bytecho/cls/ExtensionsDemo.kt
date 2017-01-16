package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/16.
 */
fun main(args: Array<String>) {
    val ea: EA = EA(1, 2)
    ea.minus()
    ea.add()
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

//extension fun do not override
fun EA.add() {
    println("override add fun")
}

//Nullable Receiver