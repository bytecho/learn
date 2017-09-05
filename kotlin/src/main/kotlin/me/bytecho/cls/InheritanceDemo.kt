package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/13.
 */
fun main(args: Array<String>) {
    val arr:Array<Any> = arrayOf(Expr.Const(3.0), Expr.Sum(1,2),Expr.NotDouble("ha"))
    for (i in arr) {
        when(i) {
          /*  is Expr.Const -> i.result()
            is Expr.Sum -> i.result()
            is Expr.NotDouble -> i.result()*/
            is Expr -> i.result()
        }
    }
}

//default final, can't be inherited. using open keyword to announce inheritance
open class Super

open class Sub1(f1: String) : Super()
class Sub2(f1: String) : Sub1(f1)

class Sub3 : Sub1 {
    constructor(name: String) : super(name)
}

//overriding members
open class Base1 {
    fun f1() {}
    open fun f2() {}
    open fun f3() {}

    open val f1: String = "";
}

open class Derive : Base1() {
    override fun f2() {}

    //final override can not re-override
    final override fun f3() {
        super.f3()
    }

    override val f1: String
        get() = "hello derive:f1"
}

class DeriveSub : Derive() {
    override fun f2() {
        super.f2()
    }

}

//Overriding Rules
/* class inherits many implementations of the same
member from its immediate superclasses, it must override this member and provide its own implementation (perhaps, using
one of the inherited ones). To denote the supertype from which the inherited implementation is taken, we use
super
 qualified
by the supertype name in angle brackets,*/
open class A {
    open fun m1() {
        println("A.m1()")
    }
}

interface B {
    fun m1() {
        println("B.m1()")
    }
}

open class Impl : A(), B {
    final override fun m1() {
        super<B>.m1()
    }
}

//Abstract Classes
/*A class and some of its members may be declared
abstract
. An abstract member does not have an implementation in its class.
Note that we do not need to annotate an abstract class or function with open – it goes without saying.*/
abstract class Ab {
    abstract fun f1()
    open fun f2() {}
}

abstract class AbSub : Ab() {
    override fun f1() {
        println("AbSub.f1() impl Ab.f1()")
    }

    abstract override fun f2()
}

//Sealed Classes
sealed class Expr() {
    abstract fun result()
    class Const(var number: Double) : Expr() {
        override fun result() {
          println("number is $number")
        }
    }
    class Sum(var i: Int, var j: Int) : Expr() {
        override fun result() {
            println("i + j = ${i + j}")
        }
    }
    class NotDouble(var arg: Any) : Expr() {
        override fun result() {
            println("number is double: ${arg is Double}")
        }
    }
}