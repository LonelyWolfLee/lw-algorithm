package codility

import utils.checkValue

fun main() {
    println("Lesson 01 : Iterations")

    // 1. Binary Gap
    checkValue(solutionOfBinaryGap(32), 0)
}

fun solutionOfBinaryGap(N: Int): Int {
    val str = Integer.toBinaryString(N)
    val arr = str.split("1").map { it.length}
    return if (str.last() == '0') arr.dropLast(1).max()!! else arr.max()!!
}