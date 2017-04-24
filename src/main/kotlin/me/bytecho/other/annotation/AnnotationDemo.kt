@file:JvmName("AnnotationDemo_Generated")

package me.bytecho.other.annotation

import kotlin.annotation.AnnotationRetention.SOURCE
import kotlin.annotation.AnnotationTarget.*
import kotlin.reflect.KClass

/**
 *
 * Created by Alan on 2017/4/24.
 */

fun main(args: Array<String>) {

}

@Target(CLASS, CONSTRUCTOR, PROPERTY, PROPERTY_SETTER, FUNCTION, EXPRESSION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Fancy

@Fancy
class AnnotationDemo @Fancy constructor(var msg: String) {
    @Fancy var cause: String = ""
    var solution: String? = null
        @Fancy set(value) {
            solution = value
        }

    @Fancy fun foo() {}
}

//annotation with parameters

/**
 *Allowed parameter types are:
 * ----types that correspond to Java primitive types (Int, Long etc.);
 * ----strings;
 * ----classes(Foo::class);
 * ----enums:
 * ----other annotations;
 * ----list of type above;
 * */

//If an annotation is used as a parameter of another annotation,
// its name is not prefixed with the @ character:
@Target(ANNOTATION_CLASS)
@Retention(SOURCE)
@MustBeDocumented
annotation class ReplaceWith(val expr: String)

@Target(FUNCTION, ANNOTATION_CLASS, CLASS, PROPERTY, CONSTRUCTOR)
@Retention(SOURCE)
@MustBeDocumented
annotation class Deprecate(val msg: String, val replace: ReplaceWith)

@Deprecate("it's not safe", ReplaceWith("dada"))
class DeprecateDemo

//If you need to specify a class as an argument of an annotation, use a Kotlin class (KClass).
@Target(CLASS)
@Retention(SOURCE)
@MustBeDocumented
annotation class AnnoWithParam(val arg1: KClass<*>, val arg2: KClass<out Any>)

@AnnoWithParam(Int::class, String::class) class AnnoWithParamDemo

//lambadas
@Target(EXPRESSION, PROPERTY, PROPERTY_SETTER, PROPERTY_GETTER, TYPE_PARAMETER, VALUE_PARAMETER, FIELD)
@Retention(SOURCE)
@MustBeDocumented
annotation class Suspendable

var f = @Suspendable { Thread.sleep(10) }

//Annotation Use-site Targets
class AnnoTargetDemo(@field:Suspendable val arg1: String,
                     @get:Suspendable val arg2: Int,
                     @param:Suspendable val arg3: Boolean)

//Java annotations are 100% compatible with Kotlin
