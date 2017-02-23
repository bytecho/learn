package me.bytecho.other

/**
 *
 * Created by Alan on 2017/2/23.
 */
fun main(args: Array<String>) {

    for (i in 1..10) {
        print("$i\t")
    }
    println("\n")

    for (i in 10 downTo 1) {
        print("$i\t")
    }
    println("\n")

    for (i in 1..10 step 2) {
        print("$i\t")
    }
    println("\n")

    for (i in 10 downTo 1 step 2) {
        print("$i\t")
    }
    println("\n")

    for (i in 1 until  10) {
        print("$i\t")
    }
    println("\n")
}