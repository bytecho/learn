package me.bytecho.other

/**
 *
 * Created by Alan on 2017/4/21.
 */


fun main(args: Array<String>) {

    var arr: Array<String?>? = null
    print(arr?.get(0)?.length)

    //safe calls
    arr = arrayOf("hello ", "world!", "oh", "this", "has", "null", null, "before", "this")
    for (item in arr) {
        item?.let{ print("$item ")}
    }

    println("\n")
    //Elvis Operator
    println(arr.get(1)?.get(3)?.dec());
    println(arr.get(6)?.get(1)?.dec());
    println(arr.get(1)?.get(5)?.dec());
    //null assert
    arr = if(arr.get(1)?.length!! > 100) arr else null

    println(arr!!.get(0));

    //safe casts
    val i = 3
    var j: Long? = i as? Long
    println(j)

    //Collections of Nullable Type
    arr.filterNotNull()
}