package me.bytecho.cost

import kotlin.properties.Delegates

/**
 *
 * Created by Alan on 2017/8/28.
 */
val lazyProp:String by lazy { "hello world" }
val notNullProp:String by Delegates.notNull<String>()