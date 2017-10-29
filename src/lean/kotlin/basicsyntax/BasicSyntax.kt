package lean.kotlin.basicsyntax

import java.util.*

fun sum(a: Int, b: Int): Int {
    return a + b;
}

fun sum1(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

fun printSum1(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf1(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    }
    else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }

    return null
}

fun getStringLength1(obj: Any): Int? {
    if (obj !is String) return null

    return obj.length
}

fun describe(obj: Any): String =
        when (obj) {
            1           -> "One"
            "Hello"     -> "Greeting"
            is Long     -> "Long"
            !is String  -> "Not a String"
            else        -> "Unknown"
        }

abstract class Shape(val sides: List<Double>) {
    val perimeter: Double get() = sides.sum()
    abstract fun calculateArea(): Double
}

interface RectangleProperties {
    val isSquare: Boolean
}

class Rectangle(
        var height: Double,
        var length: Double
) : Shape(listOf(height, length, height, length)), RectangleProperties {
    override val isSquare: Boolean get() = length == height
    override fun calculateArea(): Double = height * length
}

class Triangle(
        var sideA: Double,
        var sideB: Double,
        var sideC: Double
) : Shape(listOf(sideA, sideB, sideC)) {
    override fun calculateArea(): Double {
        val s = perimeter / 2
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }
}

/**
 * /*
 *   block comments can be nested.
 * */
 */
fun main(args: Array<String>) {
    print("sum of 3 and 5 is ")
    println(sum(3, 5))
    println("sum of 19 and 23 is ${sum1(19, 23)}")
    printSum(-1, 8)
    printSum1(-1, 8)

    // string template
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    println("max of 0 and 42 is ${maxOf(0, 42)}")
    println("max of 4 and 2 is ${maxOf1(4, 2)}")

    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... error, not a String"}")
    }
    fun printLength1(obj: Any) {
        println("'$obj' string length is ${getStringLength1(obj) ?: "... error, not a String"}")
    }
    printLength("Incomprehensibilities")
    printLength1(1000)
    printLength(listOf(Any()))

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item @ $index is ${items[index]}")
    }

    var index = 0
    while (index < items.size) {
        println("item @ $index is ${items[index]}")
        index++
    }

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    val x = 10
    val y = 9
    if (x in 1..y+1) {
        println("fits in range")
    }

    val list = listOf("a", "b", "c")

    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }

    for (i in 1..5) {
        print(i)
    }
    for (i in 1..10 step 2) {
        print(i)
    }
    for (i in 9 downTo 0 step 3) {
        print(i)
    }
    println()

    for (item in items) {
        println(item)
    }

    val items1 = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items1  -> println("juicy")
        "apple" in items1   -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    val rectangle = Rectangle(5.0, 2.0)
    val triangle = Triangle(3.0, 4.0, 5.0)
    println("Area of rectangle is ${rectangle.calculateArea()}, its perimeter is ${rectangle.perimeter}")
    println("Area of triangle is ${triangle.calculateArea()}, its perimeter is ${triangle.perimeter}")
}