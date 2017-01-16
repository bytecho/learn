package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/16.
 */

fun main(args: Array<String>) {

    // use prop
    var employee1: Employee = Employee()
    employee1.nickname = "jojo"
    println(employee1)
    println("--------------------------------------------")

    var lateInit:Employee.LateInit = Employee.LateInit("hello, lateInit")
    lateInit.prtStr()
}

class Employee {
    //declare properties
    var name: String? = null
    var id: Long = -1 // -1 means have not formal id
    var age: Int = 18
    /* getter and setter auto implicit create*/
    var nickname: String? = null
        get() = field
        set(value) {
            field = value + " hoho"
        }

    override fun toString(): String {
        return "Employee(name=$name, id=$id, age=$age, nickname=$nickname)"
    }


    //Compile-Time Constants , just in object
    object Obj {
        val f1: String? = null
            get() {
                return field + "obj.f1"
            }

        const val f2: String = "obj.f2"
//        get() {return field}
    }

    // Late-Initialized Properties
    class LateInit {
        lateinit var str:String
        constructor()
        constructor(string: String) {
            str = string
        }

        fun prtStr() {
            println("str is $str")
        }
    }

}