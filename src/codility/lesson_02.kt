package codility

import utils.checkValue

fun main() {
    println("Lesson 02 : Arrays")

    // 1. Odd Occurrences In Array
    checkValue(solutionOfOddOccurrencesInArray(arrayOf(9, 3, 9, 3, 9, 7, 9).toIntArray()),7)
}

fun solutionOfOddOccurrencesInArray(A: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    A.forEach {
        if (it !in map) map[it] = 0
        else if (map[it] == 0) map[it] = 1
    }

    return map.filter {
        it.value == 0
    }.keys.first()
}