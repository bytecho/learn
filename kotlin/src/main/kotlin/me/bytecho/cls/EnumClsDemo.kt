package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/20.
 */

fun main(args: Array<String>) {

    val animals = arrayOf(Animal.DOG, Animal.CAT)
//    val animals = Animal.values()
    for (animal in animals) {
        animal.laugh()
        animal.run()
    }

    println("----------------------------------")

    Animal.valueOf(Animal.DOG.name).laugh()

    println("-----------------------------------")

    testEnumConstantDefaultProps()
}

//enum class
enum class Direction {SOUTH, NORTH, EAST, WEST }

//Initialization
enum class Color(argb: Int) {RED(0xff0000), BLACK(0x00000) }

//Anonymous Classes as members
enum class Animal {
    DOG {
        override fun laugh() {
            println("wang wang wang ~~~")
        }
    },
    CAT {
        override fun laugh() {
            println("miao miao miao ~~~")
        }
    };

    fun run() {
        println("run run run ~~~")
    }

    abstract fun laugh()
}

//Every enum constant has properties to obtain its name and position in the enum class declaration
fun testEnumConstantDefaultProps() {
    for (color in Color.values()) {
        println("color name is ${color.name}, color ordinal is ${color.ordinal}")
    }
}
