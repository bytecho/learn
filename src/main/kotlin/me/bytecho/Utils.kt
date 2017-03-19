package me.bytecho

/**
 *
 * Created by Alan on 2017/2/5.
 */
object Utils {
    private val TAG_PREF = "bytecho-- "

    fun prtRightCutLine() {
        println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    }

    fun prtLeftCutLine() {
        println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
    }


    fun prtRightCutTag(tag: String) {
        println(TAG_PREF + tag + ":  ------------------------------------>")
    }

    fun prtLeftCutTag(tag: String) {
        println(TAG_PREF + tag + ":  <-------------------------------------")
    }
}