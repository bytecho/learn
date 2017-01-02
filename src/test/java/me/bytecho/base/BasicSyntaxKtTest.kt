package me.bytecho.base

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Alan Wang on 2017-1-2.
 */
class BasicSyntaxKtTest {
    @Before
    fun setUp() {
        println("test------------------->start:")
    }

    @After
    fun tearDown() {
        println("test------------------->start:")
    }

    @Test
    fun parseInt() {
      assert(me.bytecho.base.parseInt("2") == 2)
    }

}