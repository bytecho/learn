package me.bytecho.base

/**
 * Created by Alan Wang on 2017-1-2.
 */
fun main(args: Array<String>) {
    val arr = arrayOf("hello", "world", "i", "am", "no.9")

    //for in
    println("loop---------->for in")
    for (s in arr) print(s + "\t")
    println()

    //while
    println("loop---------->while")
    var i = 0
    while (i < arr.size) {
        print(arr[i] + "\t")
        i++
    }
    println()

    //do while
    println("loop---------->do while")
    i = 0
    do {
        print(arr[i] + "\t")
        i++
    } while (i < arr.size)
    println()

    //when expr
    println("expr---------->when")
    for (s in arr) {
        when (s.length) {
            in 0..1 -> println("$s len is small than 2")
            2 -> println("$s len is 2")
            else -> println("$s len is larger than 2")
        }
    }

    //using range
    val ii = 9
    //in include start include end
    if (ii in 0..5) print("$ii is in 0~5")
    else print("$ii is out 0~5")
}