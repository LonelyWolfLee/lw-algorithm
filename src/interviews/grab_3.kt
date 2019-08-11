package interviews

import utils.checkValue

fun main() {
    checkValue(solution03(intArrayOf(0,3,3,7,5,3,11,1)), 0)
    checkValue(solution03(intArrayOf(0,-1,3,7,5,11)), 1)

}

fun solution03(A: IntArray): Int {
    // write your code in Kotlin
    if (A.size == 1) return -2

    val MAX = 100000000
    var min = MAX

    A.sort()
    var curr = A[0]

    for (n in 1 until A.size) {
        val dist = A[n] - curr
        if (dist == 0) return 0
        if (dist < min) min = dist
        curr = A[n]

    }

    return if (min > MAX) -1 else min
}