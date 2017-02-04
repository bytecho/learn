package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/2/4.
 */


/*Sometimes we need to create an object of a slight modification of some class,
without explicitly declaring a new subclass for it. Java handles this case with anonymous inner classes.
 Kotlin slightly generalizes this concept with object expressions and object declarations*/


fun main(args: Array<String>) {
    textExpr()
    testSingle()
}


//object expression
private fun textExpr() {
    testObj(object : MouseAdapter() {
        override fun mouseFocused() {
            super.mouseFocused()
        }

        override fun mouseClicked() {
            super.mouseClicked()
        }
    })

    val nonSuperObj = object {
        val x = 233
        fun prtX() {
            println("x is $x")
        }
    }

    nonSuperObj.prtX()
}

open class MouseAdapter {
    open fun mouseFocused() {
        println("focused")
    }

    open fun mouseClicked() {
        println("clicked")
    }
}

fun testObj(adapter: MouseAdapter) {
    adapter.mouseFocused()
    adapter.mouseClicked()
}

//object declaration

//singleton
object SingleDog {
    fun noFun() {
        println("single all the always.~~~dog")
    }
}

//companion object. just an object in class
class SingleCat private constructor() {
    companion object {
        fun instance(): SingleCat = SingleCat()
    }

    fun noFun() {
        println("single all the always.~~~cat")
    }
}

fun testSingle() {
    SingleDog.noFun()
    SingleCat.instance().noFun()
}

/*There is one important semantic difference between object expressions and object declarations:
-----object expressions are executed (and initialized)  immediately, where they are used
-----object declarations are initialized lazily, when accessed for the first time
-----a companion object is initialized when the corresponding class is loaded (resolved),
 matching the semantics of a Java static initialize*/