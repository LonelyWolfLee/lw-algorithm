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