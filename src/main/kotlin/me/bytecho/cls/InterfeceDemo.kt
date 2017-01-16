package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/16.
 */
fun main(args: Array<String>) {

    val impl: MyInterface = MyInterfaceImpl()
    impl.foo()
    impl.prt()
}

interface MyInterface {
    var str: String

    fun foo()
    fun prt() {
        println("hello $str")
    }
}

interface MyInterface2 {
    fun foo()
    fun prt() {
        print("this is MyInterface2")
    }
}

class MyInterfaceImpl : MyInterface, MyInterface2 {
    override var str: String = "hello Impl"

    override fun foo() {
        println("override fun foo")
    }

    override fun prt() {
        super<MyInterface2>.prt()
    }
}