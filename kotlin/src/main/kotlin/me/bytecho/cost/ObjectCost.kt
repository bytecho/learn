package me.bytecho.cost

import java.util.*

/**
 *
 * Created by Alan on 2017/8/28.
 */
object ObjectCost {
    //var & val & lateinit
    var strVar: String = "strVar"
    val strVal: String = "strVal"
    lateinit var strLateInit: String

    //const
    const val strConst: String = "strConst"

    //jvmField
    @JvmField
    val jvmStaticObj: Date = Date()

    init {
        println("this is init block of ObjectCost")
    }

    //fun
    fun commonFun(string: String) {
        println(string)
    }

    //jvmstatic fun
    @JvmStatic
    fun jvmStaticFun(string: String) {
        println(string)
    }
}