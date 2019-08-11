package interviews

import utils.checkValue

fun main() {
    checkValue(solution02(intArrayOf(2,2,3,4,3,3,2,21,1,2,5)), 4)
    checkValue(solution02(intArrayOf(5,4,3,2,1,2,1,5)), 4)
}

fun solution02(A: IntArray): Int {
    // write your code in Kotlin

    if (A.size <= 2) return 1

    var num = 0

    var prev = A[0]
    var d = 1

    for (i in 1 until A.size) {
        if (A[i] != prev) {
            if (prev < A[i]) {
                if (d == 0) {
                    d = 1
                    num++
                }
            } else {
                if (d == 1) {
                    d = 0
                    num++
                }
            }
            prev = A[i]
        }
    }

    return num
}
