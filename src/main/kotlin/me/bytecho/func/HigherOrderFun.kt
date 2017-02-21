package me.bytecho.func

import me.bytecho.Utils
import java.util.*

/**
 *
 * Created by Alan on 2017/2/5.
 */

fun main(args: Array<String>) {
    testFuncParam()
    Utils.prtRightCutLine()
    testMapFunc()
    Utils.prtLeftCutLine()
    testStringsFunc()
    Utils.prtRightCutLine()
    testHtml()
    testInstance()
}

open class AAA {}
class BBB : AAA() {}

fun testInstance() {
    val a: BBB = BBB()
    println(a is AAA)
}

//fun as param
fun concatEach(subFix: String, arr: () -> ArrayList<String>) {
    arr.invoke().forEach { s -> s.plus(subFix) }
    println(arr.invoke())
}

private fun testFuncParam() {
    concatEach("-subFix", {
        val arr: ArrayList<String> = ArrayList()
        for (i in 1..10) {
            arr.add("ele$i")
        }
        return@concatEach arr
    })
}

fun <T, R> List<T>.map(transform: (T) -> R): List<R> {
    val arr = ArrayList<R>()
    for (e in this) arr.add(transform(e))
    return arr
}

fun testMapFunc() {
    println(arrayListOf(1, 2, 3).map { it -> it * 2 })
}

fun testStringsFunc() {
    println(
            arrayOf("d", "p", "k", "v", "a", "b", "c", "aa", "bb", "cc")
                    .filter { it.length == 1 }
                    .sortedBy { it }
                    .map { it.toUpperCase() }
    )
}

//fun as return type
fun funAsReturn(): () -> String {
    return fun() = "hello"
}

//lambada
/*full syntactic*/
val sum = { x: Int, y: Int -> x + y }

/*if fun just has one param, reference can use an express with it instead as above filter func*/

//anonymous func
/*specify return type.
---- Note that anonymous function parameters are always passed inside the parentheses. The shorthand syntax allowing to leave
the function outside the parentheses works only for lambda expression.
----  A return statement without a label always returns from the function declared with the fun keyword. This means that a
return inside a lambda expression will return from the enclosing function, whereas a
return inside an anonymous function will return from the anonymous function itself.
*/
fun testAnonymousFunc() {
    println(
            arrayOf(1, 2, 3)
                    .filter(fun(it): Boolean { return it > 2 })
    )

    //or
    println(
            arrayOf(1, 2, 3)
                    .filter(fun(it) = it > 2)
    )
}

//Closures
fun testClosures() {
    var sum = 0
    arrayOf(1, 2, 3)
            .forEach { sum + it }
}


//Function Literals with Receiver
class Html {
    fun head() {
        println("html----->head")
    }

    fun body() {
        println("html----->body")
    }
}

fun html(init: Html.() -> Unit): Html {
    val html = Html()
    html.init()
    return html
}

fun testHtml() {
    html {
        head()
        body()
    }
}

//inline fun
/*
The inline modifier affects both the function itself and the lambdas passed
to it: all of those will be inlined into the call site
*/
inline fun lock(body: () -> Unit) {
}

//noinline fun param
inline fun lock2(lock: () -> Unit, noinline body: () -> Unit) {
}

//Non-local returns
fun testLock2() {
//    lock2({ return Unit }, { return Unit })  note: noinline fun param can't  return barely
    lock2({ return Unit }, { return@lock2 }) //can return with label

    //inline fun can return direct
    lock { return Unit }
}

fun hasZeros(ints: Array<Int>): Boolean {
    ints.forEach { if (it == 0) return false }
    return true
}

/*
Note that some inline functions may call the lambdas passed to them as parameters not directly from the function body, but
from another execution context, such as a local object or a nested function. In such cases, non-local control flow is also not
allowed in the lambdas. To indicate that, the lambda parameter needs to be marked with the crossinline modifier
*/
inline fun f(crossinline body: () -> Unit) {
    val thread = Runnable { body() }
}
/*break and continue are not yet available in inlined lambdas, but we are planning to support them too*/

//Reified type parameters
inline fun <reified T> members() = T::class.members


