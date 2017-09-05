package me.bytecho.other

/**
 *
 * Created by Alan on 2017/4/24.
 */

//exceptions don't need to check in kotlin, and all were runtime exceptions
fun main(args: Array<String>) {
    try {
        val i = div(18, 0)
    } catch (e: DividerByZeroException) {
        e.printStackTrace()
    } finally {
        println("this is an exception")
    }
}


/**
 * @throws DividerByZeroException
 * */
fun div(i: Int, j: Int): Int {
    if (j === 0) throw DividerByZeroException(message = "divider is zero")
    return i / j
}

open class DividerByZeroException(message: String?, cause: Throwable?) : Throwable(message, cause) {
    constructor() : this(null, null)
    constructor(message: String?) : this(message, null)
    constructor(cause: Throwable?) : this(null, cause)

}