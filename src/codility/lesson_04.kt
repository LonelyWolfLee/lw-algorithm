package codility

import utils.checkValue

fun main() {
    println("Lesson 04 : Counting Elements")

    // 1. Perm Check
    checkValue(solutionOfPermCheck(arrayOf(4,1,3,2).toIntArray()), 1)
    checkValue(solutionOfPermCheck(arrayOf(4,1,3).toIntArray()), 0)
    checkValue(solutionOfPermCheck(arrayOf(1).toIntArray()), 1)
    checkValue(solutionOfPermCheck(arrayOf(2).toIntArray()), 0)
    checkValue(solutionOfPermCheck(arrayOf(1,1,1).toIntArray()), 0)
    checkValue(solutionOfPermCheck(arrayOf(1,1,3).toIntArray()), 0)

    // 2. Frog River One
    checkValue(solutionOfFrogRiverOne(5, arrayOf(1,3,1,4,2,3,5,4).toIntArray()), 6)
    checkValue(solutionOfFrogRiverOne(5, arrayOf(1,3,1,4,2,3,4).toIntArray()), -1)
    checkValue(solutionOfFrogRiverOne(1, arrayOf(1).toIntArray()), 0)

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