package me.bytecho.cls

import me.bytecho.Utils
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 *
 * Created by Alan on 2017/2/4.
 */

fun main(args: Array<String>) {
    testDelegatedClass()
    Utils.prtRightCutLine()
    testDelegatedProp()
    Utils.prtLeftCutLine()
    testLazyDelegated()
    Utils.prtRightCutLine()
    testObservableDelegated()
    Utils.prtLeftCutLine()
    testStoringDelegated()
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

private fun testDelegatedClass() {
    val b: Base = BaseImpl()
    Derived(b).out()
}


//delegated properties
/*
There are certain common kinds of properties, that, though we can implement them manually every time we need them,
would be very nice to implement once and for all, and put into a library. Examples include:

--------lazy properties: the value gets computed only upon first access,
--------observable properties: listeners get notified about changes to this property,
--------storing properties in a map, not in separate field each
*/

class PropDelegateBase {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class PropDelegate {
    var prop: String by PropDelegateBase()
}

/*
Property Delegate Requirements:

For a read-only property (i.e. a val), a delegate has to provide a function named
getValue that takes the following parameters:
---------receiver — must be the same or a supertype of the property owner
(for extension properties — the type being extended),
---------metadata — must be of type KProperty<*> or its supertype,
this function must return the same type as property (or its subtype.

For a mutable property (a var), a delegate has to additionally provide a function named
setValue that takes the following parameters:
---------receiver — same as for getValue(),
---------metadata — same as for getValue(),
---------new value — must be of the same type as a property or its supertype
*/
fun testDelegatedProp() {
    val e: PropDelegate = PropDelegate()
    e.prop = "haha"
    println(e.prop)
}


//lazy
/*
By default, the evaluation of lazy properties is synchronized: the value is computed
only in one thread, and all threads will see the same value. If the synchronization of initialization
delegate is not required, so that multiple threads can execute it simultaneously.
pass LazyThreadSafetyMode.PUBLICATION as a parameter to the lazy() function. And if you're sure that the
initialization will always happen on a single thread, you can use LazyThreadSafetyMode.NONE mode, which
doesn't incur any thread-safety guarantees and the related overhead.
*/
class LazyDelegatedDemo {
    val lazyProp: String by lazy {
        println("lazy init")
        "hello"
    }
}

fun testLazyDelegated() {
    val lazy: LazyDelegatedDemo = LazyDelegatedDemo()
    println(lazy.lazyProp)
    println(lazy.lazyProp)
}


//Observable
class ObservableDelegatedDemo {
    var observableProp: String by Delegates.observable("") {
        prop, old, new ->
        println("${prop.name} old is $old, new is $new")
    }

    var vetoProp: String by Delegates.vetoable("") {
        prop, old, new ->
        new.contains("a")
    }
}

fun testObservableDelegated() {
    val observable: ObservableDelegatedDemo = ObservableDelegatedDemo()
    observable.observableProp = "new prop1"
    observable.observableProp = "new prop2"

    println("~~~~~~~~~")

    observable.vetoProp = "aaa"
    println(observable.vetoProp)
    observable.vetoProp = "bbb"
    println(observable.vetoProp)
}


//storing
/*
This works also for var’s properties if you use a
MutableMap instead of read-only Map
*/
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun testStoringDelegated() {
    val user1: User = User(mapOf("name" to "bobo", "age" to 23))
    println("user1.name is ${user1.name}, user1.age is ${user1.age}")
}
