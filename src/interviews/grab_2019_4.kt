package interviews

import utils.checkValue

fun main() {


    // 4
    checkValue(solution(38), 40)
    checkValue(solution(21), 32)
    checkValue(solution(17), 18)
    checkValue(solution(18), 20)
    checkValue(solution(19), 20)
    checkValue(solution(20), 21)
//
    checkValue(solution(0), 1)
    checkValue(solution(1), 2)
    checkValue(solution(2), 4)
    checkValue(solution(3), 4)
    checkValue(solution(4), 5)
    checkValue(solution(5), 8)
    checkValue(solution(6), 8)
    checkValue(solution(7), 8)
    checkValue(solution(8), 9)
    checkValue(solution(9), 10)
    checkValue(solution(10), 16)
    checkValue(solution(11), 16)
    checkValue(solution(12), 16)
    checkValue(solution(13), 16)
    checkValue(solution(14), 16)
    checkValue(solution(15), 16)
    checkValue(solution(16), 17)
    checkValue(solution(32), 33)
    checkValue(solution(33), 34)
    checkValue(solution(34), 36)
    checkValue(solution(36), 37)
    checkValue(solution(37), 40)
    checkValue(solution(39), 40)
    checkValue(solution(40), 41)
    checkValue(solution(41), 42)
    checkValue(solution(47), 64)
    checkValue(solution(48), 64)
    checkValue(solution(49), 64)

}





fun solution(N: Int): Int {
    // write your code in Kotlin
    if (N == 0) return 1
    if (N == 1) return 2

    var shiftCnt = 0
    var tmp = N
    for (i in 1..31) {
        tmp = tmp shr 1
        if (tmp == 1) {
            shiftCnt = i
            break
        }
    }

    var checker = 1 shl (shiftCnt-1)
    var next = (1 shl (shiftCnt + 1)) -1

    var checkValue = next - checker
    if (N >= checkValue) return next + 1
    while (checker > 2) {
        checker = checker shr 1
        checkValue -= checker
        if (N >= checkValue) {
            val v = checkValue + (checker shr 1)
            if (N < v) return N + 1
            else return next + 1
        } else {
            next = checkValue
        }
    }

    checker = checker shr 1
    checkValue -= checker
    if (N >= checkValue)  return N + 1

    return 0
}