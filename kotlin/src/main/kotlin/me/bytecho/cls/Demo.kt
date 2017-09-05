package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/12.
 */

fun main(args: Array<String>) {
    val d = Demo()
    val d2 = Demo2("demo2")

    val p = Person("NO.9")
    val p2 = Person2("NO.5", 233233233, 23)

    ObjCls.str = "this is obj cls"
    ObjCls.prt()
}

//class with empty body
class Demo

//class with constructor
class Demo2(f: String)

//secondary constructor
class Demo3 {
    var name: String = "";

    constructor(name: String) {
        this.name = name;
    }
}

class Demo4(fName: String) {
    constructor(fName: String, lName: String) : this(fName) {
        println("fName is $fName, lName is $lName")
    }
}

class Person constructor(name: String) {
    init {
        println("init another person, name is $name")
    }

    //init properties
    val prop1 = name.toUpperCase()

    override fun equals(other: Any?): Boolean {
        return other is Person && other.prop1.equals(prop1)
    }
}

class Person2(val name: String, val id: Long, var age: Int) {

    init {
        println("init Person2: name is $name, id is$id, age is $age")
    }
}

/*Classes can contain
--Constructors and initializer blocks
--Functions
--Properties
--Nested and Inner Classes
--Object Declaration*/
class MemberDemo {
    //constructors
    constructor(f: String)

    //initializer blocks
    init {
        println("hello")
    }

    //func
    fun prtInfo() {
        println(toString())
    }

    //prop
    public var name: String = ""

    //inner class
    class Inner

    //obj declaration
    //In Kotlin, unlike Java or C#, classes do not have static methods. In most cases, it's recommended to simply use package-level
    //functions instead
    //Even more specifically, if you declare a companion object inside your class
    companion object Instance {
        fun getInstance(): MemberDemo = MemberDemo("hou")
    }
}

object ObjCls {
    var str: String?= null
    fun prt() {println("$str")}
}
