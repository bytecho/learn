package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/2/4.
 */

fun main(args: Array<String>) {
    val b: Base = BaseImpl()
    Derived(b).out()
}

//delegated class
interface Base {
    fun out()
}

class BaseImpl : Base {
    override fun out() {
        println("override fun out by BaseImpl")
    }
}

/*The by-clause in the supertype list for Derived
 indicates that b will be stored internally in objects of
 Derived and the compiler will generate all the methods of
Base that forward to b*/
class Derived(val b: Base) : Base by b {
    override fun out() {
        b.out()
        println("override fun out by Derived")
    }
}



//delegated properties
/*
There are certain common kinds of properties, that, though we can implement them manually every time we need them,
would be very nice to implement once and for all, and put into a library. Examples include:

--------lazy properties: the value gets computed only upon first access,
--------observable properties: listeners get notified about changes to this property,
--------storing properties in a map, not in separate field each
*/
