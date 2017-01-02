package me.bytecho.basic

/**
 * Created by Alan Wang on 2017-1-2.
 */
fun main(args: Array<String>) {
    //numbers
    val doubleMin: Double = Double.MIN_VALUE
    val doubleMax: Double = Double.MIN_VALUE
    val floatMin: Float = Float.MIN_VALUE
    val floatMax: Float = Float.MAX_VALUE
    val longMin: Long = Long.MIN_VALUE
    val longMax: Long = Long.MAX_VALUE
    val intMin: Int = Int.MIN_VALUE
    val intMax: Int = Int.MAX_VALUE
    val shortMin: Short = Short.MIN_VALUE
    val shortMax: Short = Short.MAX_VALUE
    val charMIn: Char = Char.MIN_SURROGATE
    val charMax: Char = Char.MAX_SURROGATE

    val arr = arrayOf(doubleMin, doubleMax, floatMin, floatMax,
            longMin, longMax, intMin, intMax, shortMin, shortMax, charMIn, charMax)

    for (any in arr) {
        println(any.toString())
    }

    //Literal Constants
    val l = 123L //long var
    val l1 = 0xff //hex var
    val l3 = 0b0011 //bin var
    val d1 = 123.23333 //double var
    val f1 = 123.33f // float var
}