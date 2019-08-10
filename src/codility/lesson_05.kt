package codility

import utils.checkValue

fun main() {
    println("Lesson 05 : Prefix Sums")

    // 1. Passing Cars
    checkValue(solutionOfPassingCars(intArrayOf(0,1,0,1,1)), 5)
    checkValue(solutionOfPassingCars(intArrayOf(0)), 0)
    checkValue(solutionOfPassingCars(intArrayOf(0,0)), 0)
    checkValue(solutionOfPassingCars(intArrayOf(1,0)), 0)
    checkValue(solutionOfPassingCars(intArrayOf(0,1)), 1)
}

// 100%
fun solutionOfPassingCars(A: IntArray): Int {
    val total = A.size
    if (total == 1) return 0

    val arrP = arrayListOf<Int>()
    A.forEachIndexed {
        index, i -> if (i == 0) arrP.add(index)
    }

    var totalPair = 0

    for ((handledP, i) in (arrP.size-1 downTo 0).withIndex()) {
        totalPair += (total-1) - arrP[i] - handledP
        if (totalPair > 1000000000) return -1
    }

    return totalPair
}