package codility

import utils.checkValue
import kotlin.math.abs

fun main() {
    println("Lesson 03 : Time Complexity")

    // 1. FrogJmp
    checkValue(solutionOfFrogJmp(10, 85, 30), 3)

    // 2. PermMissingElem
    checkValue(solutionOfPermMissingElem(intArrayOf(2, 3, 1, 5)), 4)

    // 3. TapeEquilibrium
    checkValue(solutionOfTapeEquilibrium(intArrayOf(3, 1, 2, 4, 3)), 1)
    checkValue(solutionOfTapeEquilibrium(intArrayOf(1000, -1000)), 2000)
}

// 100% O(1)
fun solutionOfFrogJmp(X: Int, Y: Int, D: Int): Int {
    if (X == Y) return 0
    val N = (Y-X) / D
    val C = (Y-X) % D
    return if (C == 0) N else N+1
}

// 100% O(N) or O(NlogN)
fun solutionOfPermMissingElem(A: IntArray): Int {
    val actual = A.sum().toBigInteger()
    val expect = ((A.size+1).toBigInteger() * (A.size+2).toBigInteger()).divide(2.toBigInteger())
    return (expect - actual).toInt()
}

// 100% O(N)
fun solutionOfTapeEquilibrium(A: IntArray): Int {
    var sum = A.sum()
    var acc = 0
    var minDiff = 2000
    for (i in 0 until A.size-1) {
        acc += A[i]
        sum -= A[i]
        val diff = abs(sum-acc)
        if (diff < minDiff) minDiff = diff
    }

    return minDiff
}