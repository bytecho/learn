package me.bytecho.other

import me.bytecho.Utils
import java.util.*

/**
 *
 * Created by Alan on 2017/2/22.
 */

fun main(args: Array<String>) {
    var (name, age) = PersonDes.instance
    println("name is $name , age is $age")
    Utils.prtRightCutLine()

    val ps: ArrayList<PersonDes2> = ArrayList()
    ps.add(PersonDes2("one", 1))
    ps.add(PersonDes2("two", 2))
    ps.add(PersonDes2("three", 3))
    ps.add(PersonDes2("four", 4))
    Utils.prtLeftCutLine()

    for ((a,b) in ps) {
        println(" a is $a, b　is $b")
    }
    Utils.prtRightCutLine()

    var (a,b) = getPersonDes2Info()
    println("a is \"$a\", b is $b")
}

class PersonDes(var name: String, var age: Int) {
    companion object {
        val instance: PersonDes = PersonDes("ha", 23)
    }

    operator fun component1() = name
    operator fun component2() = age

}

data class PersonDes2(var name: String, var age: Int)

fun getPersonDes2Info(): PersonDes2 = PersonDes2("test return two values", 233)
