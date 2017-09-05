package me.bytecho.other

import me.bytecho.Utils

/**
* Created by Alan Wang on 2017-3-13.
*/

fun main(args: Array<String>) {

    Utils.prtRightCutTag("is and !is")
    testIs("haha")
    testIs(123)
    Utils.prtLeftCutTag("smart cast")
    testSmartCast("hahahah")
    testSmartCast(233)
    Utils.prtRightCutTag("unsafe cast")
    var x: String? = null
    testUnsafeCast(x)
    x = "hello world"
    testUnsafeCast(x)
}

fun testIs(obj: Any) {
    if(obj is String) println(obj.length) // obj auto cast to string
    if(obj !is String) println("obj is not a string")
}

fun testSmartCast(obj: Any) {
    when(obj) {
        is String -> println("obj is string, len is ${obj.length}")
        is Int -> println("obj is int, obj + 2 is ${obj + 2}")
    }
}

fun testUnsafeCast(obj: Any?) {
    //unsafe
   /* val x: String = obj as String
    println("x: $x length is ${x.length}")*/

    /*val x: String? = obj as String?*/ //same as below code
    val x: String? = obj as? String
    println("x: $x length is ${x?.length}")
}
