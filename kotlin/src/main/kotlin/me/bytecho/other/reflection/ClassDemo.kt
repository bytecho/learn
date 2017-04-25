package me.bytecho.other.reflection

/**
 *
 * Created by Alan on 2017/4/24.
 */
class ClassDemo constructor(var name: String, val id: Long, var remark: String?) {

    constructor(name: String, id: Long) : this(name, id, null)

    fun prt(msg: String) {
        println("name is $name, id is $id, msg：$msg")
    }

    val f = { println("this is an lambada") }
}