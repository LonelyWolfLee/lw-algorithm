package codility

import utils.checkValue

fun main() {
    println("Lesson 02 : Arrays")

    // 1. Odd Occurrences In Array
    checkValue(solutionOfOddOccurrencesInArray(arrayOf(9, 3, 9, 3, 9, 7, 9).toIntArray()),7)
    checkValue(solutionOfOddOccurrencesInArray(arrayOf(42).toIntArray()),42)
}

// 100%
fun solutionOfOddOccurrencesInArray(A: IntArray): Int {
    // 77% O(N^2)
//    val map = mutableMapOf<Int, Int>()
//    A.forEach {
//        if (map.containsKey(it)) map[it] = map[it]!! + 1
//        else map[it] = 1
//    }
//    return map.filter { it.value % 2 == 1  }.keys.first()

    // 88% O(N) or O(NlogN)
//    val map = mutableMapOf<Int, Int>()
//    A.forEach {
//        if (map.containsKey(it)) map.remove(it)
//        else map[it] = 1
//    }
//    return map.keys.first()

    // 88% O(N) or O(NlogN)
//    A.sort()
//    if (A.size == 1) return A[0]
//    for (i in 0 until A.size-1 step 2) {
//        if (A[i] != A[i+1]) return A[i]
//    }
//    return A.last()

    // 100%
    return A.reduce { acc, i -> acc xor i }
}