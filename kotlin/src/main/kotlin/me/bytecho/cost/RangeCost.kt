package me.bytecho.cost

/**
 *
 * Created by Alan on 2017/8/28.
 */
fun main(args: Array<String>) {

    /*  for (i in 0..10) {
          println("i")
      }*/

    /* for (i in 0 until 10) {
         println("i")
     }*/

    /* for (i in 0..10 step 2) {
         println(i)
     }*/

    //iterator
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 10)
    /*  for (i in arr) {
          println(i)
      }
      for (i in arr.indices) {
          println(i)
      }*/

    arr.forEach { println(it) }

    var list = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7)
    list.forEach { println(it) }

    for (i in list.indices) {
        println(i)
    }
}