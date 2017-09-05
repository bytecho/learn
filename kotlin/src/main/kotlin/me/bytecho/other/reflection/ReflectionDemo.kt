package me.bytecho.other.reflection

import me.bytecho.Utils
import kotlin.reflect.full.memberProperties

/**
 *
 * Created by Alan on 2017/4/24.
 */

fun main(args: Array<String>) {
    val demo: ClassDemo = ClassDemo("cd", 1)
    getDemoInfo(demo)
}

fun getDemoInfo(demo: ClassDemo) {
    val clazz = demo::class

    //base info
    println("simpleName: ${clazz.simpleName}" +
            "    qualified:${clazz.qualifiedName}" +
            "    visibility:${clazz.visibility}")
    Utils.newLine()

    //constructors
    clazz.constructors.forEach { it ->
        it.parameters.forEach { it ->
            print("${it.name}:${it.type}  ")
        }
        Utils.newLine()
    }

    //props
    val props = clazz.memberProperties
    props.forEach { it -> print("name: ${it.name}  ") }
    Utils.newLine()

    //fun reflect
    println("::isOdd(3) ${::isOdd.call(4)}")
}

fun isOdd(i: Int): Boolean = i % 2 == 0
