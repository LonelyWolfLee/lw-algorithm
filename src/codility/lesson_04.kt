package codility

import utils.checkIntArray
import utils.checkValue

fun main() {
    println("Lesson 04 : Counting Elements")

    // 1. Perm Check
    checkValue(solutionOfPermCheck(intArrayOf(4,1,3,2)), 1)
    checkValue(solutionOfPermCheck(intArrayOf(4,1,3)), 0)
    checkValue(solutionOfPermCheck(intArrayOf(1)), 1)
    checkValue(solutionOfPermCheck(intArrayOf(2)), 0)
    checkValue(solutionOfPermCheck(intArrayOf(1,1,1)), 0)
    checkValue(solutionOfPermCheck(intArrayOf(1,1,3)), 0)

    // 2. Frog River One
    checkValue(solutionOfFrogRiverOne(5, intArrayOf(1,3,1,4,2,3,5,4)), 6)
    checkValue(solutionOfFrogRiverOne(5, intArrayOf(1,3,1,4,2,3,4)), -1)
    checkValue(solutionOfFrogRiverOne(1, intArrayOf(1)), 0)

    // 3. Max Counter
    checkIntArray(solutionOfMaxCounters(5, intArrayOf(3,4,4,6,1,4,4)), intArrayOf(3,2,2,4,2))
}

// %100
fun solutionOfPermCheck(A: IntArray): Int {
    A.sort()
    if (A.first() != 1 || A.last() != A.size) return 0
    var curr = 0
    A.forEach {
        if (it == curr) return 0
        curr = it
    }
    return 1
}

// 100%
fun solutionOfFrogRiverOne(X: Int, A: IntArray): Int {
    val set = (1..X).toHashSet()
    A.forEachIndexed { index, i ->
        if (set.contains(i)) set.remove(i)
        if (set.isEmpty()) return index
    }
    return -1
}

// %100 O(N + M)
fun solutionOfMaxCounters(N: Int, A: IntArray): IntArray {
    var maxLine = 0
    var currMax = 0
    val ans = IntArray(N) {0}
    A.forEach {
        if (it == (N+1)) maxLine = currMax
        else {
            if (ans[it-1] < maxLine) ans[it-1] = maxLine + 1 else ans[it-1] += 1
            if (ans[it-1] > currMax) currMax = ans[it-1]
        }
    }
    return ans.map {
        if (it < maxLine) maxLine else it
    }.toIntArray()
}