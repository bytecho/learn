package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/20.
 */

fun main(args: Array<String>) {

    println(Outer.Inner().foo())

    println(Outer().Inner2().foo())

    setClickListener(object : ClickListener {
        override fun onClick() {
            println("listener:onclick")
        }
    })

//    setClickListener(listener ->{ println("listener:onclick") }) TODO turn to lambada syntax
}

class Outer {
    val outerField: Int = 233

    class Inner {
        fun foo(): Int = 3
    }

    inner class Inner2 {
        fun foo(): Int = outerField
    }

}

//anonymous inner class
interface ClickListener {
    fun onClick()
}

fun setClickListener(listener: ClickListener) {
    listener.onClick()
}
