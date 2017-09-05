package me.bytecho.basic

/**
 *
 * Created by Alan on 2017/1/4.
 */
fun main(args: Array<String>) {
    //raw string
    val rawStr = """
fun main(args: Array<String> {
    println("hello world")
}

//end line
"""
    println(rawStr)

    //margin prefix
    val rawStr2 = """
        |fun main(args: Array<String> {
        |   println("hello world")
        |}
    """.trimMargin()
    println(rawStr2)

    //string templates
    val s1 = 233;
    println("s1 is $s1")

    val s2 = "hello world"
    println("$s2'len is ${s2.length}")

    val s3 = """
        |$s2
        |${'$'}
    """.trimMargin()
    println(s3)
}