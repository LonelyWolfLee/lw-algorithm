package codility

import utils.checkIntArray
import utils.checkValue

fun main() {
    println("Lesson 05 : Prefix Sums")

    // 1. Passing Cars
    checkValue(solutionOfPassingCars(intArrayOf(0,1,0,1,1)), 5)
    checkValue(solutionOfPassingCars(intArrayOf(0)), 0)
    checkValue(solutionOfPassingCars(intArrayOf(0,0)), 0)
    checkValue(solutionOfPassingCars(intArrayOf(1,0)), 0)
    checkValue(solutionOfPassingCars(intArrayOf(0,1)), 1)

    // 2. Genomic Range Query
    checkIntArray(solutionOfGenomicRangeQuery("CAGCCTA", intArrayOf(2,5,0), intArrayOf(4,5,6)), intArrayOf(2,4,1))
    checkIntArray(solutionOfGenomicRangeQuery("CCCCCCC", intArrayOf(2,5,0), intArrayOf(4,5,6)), intArrayOf(2,2,2))
}

// 100% O(N)
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

fun solutionOfGenomicRangeQuery(S: String, P: IntArray, Q: IntArray): IntArray {
    // 62% O(N * M)
//    val ans = arrayListOf<Int>()
//    for ((idx, p) in P.withIndex()) {
//        ans.add(when(S.slice(p..Q[idx]).min()!!){
//            'A' -> 1
//            'C' -> 2
//            'G' -> 3
//            'T' -> 4
//            else -> 0
//        })
//    }
//    return ans.toIntArray()

    // 87% O(N + M)
//    val pairs = arrayListOf<Pair<Char, Int>>()
//    var currChar = S.first()
//    var currCnt = 0
//    S.forEach {
//        if (it == currChar) {
//            currCnt++
//        }
//        else {
//            pairs.add(Pair(currChar, currCnt))
//            currChar = it
//            currCnt = 1
//        }
//    }
//    pairs.add(Pair(currChar, currCnt))
//
//    fun findIndexOfPair(pairs: List<Pair<Char, Int>>, index: Int): Int {
//        var cnt = 0
//        pairs.forEachIndexed { idx, pair ->
//            cnt += pair.second
//            if (cnt > index) return idx
//        }
//        return pairs.lastIndex
//    }
//
//    val ans = arrayListOf<Int>()
//    for (i in 0 until P.size) {
//        val pairIdxForP = findIndexOfPair(pairs, P[i])
//        val pairIIdxForQ = findIndexOfPair(pairs, Q[i])
//
//        var min = 4
//        for (j in pairIdxForP..pairIIdxForQ) {
//            val first = pairs[j].first
//            if (first == 'A') {
//                min = 1
//                break
//            }
//            when(first) {
//                'C' -> if (min > 2) min = 2
//                'G' -> if (min > 3) min = 3
//                else {
//                }
//            }
//        }
//        ans.add(min)
//    }
//
//    return ans.toIntArray()

    // 100% O(N + M)
    data class DnaCnt(val A: Int, val C: Int, val G: Int)
    val ans = IntArray(P.size)
    val cntList = mutableListOf<DnaCnt>()

    S.forEachIndexed { index, c ->
        val lastCnt = if (index == 0) DnaCnt(0,0,0) else cntList[index-1]
        when (c) {
            'A' -> cntList.add(DnaCnt(lastCnt.A+1, lastCnt.C, lastCnt.G))
            'C' -> cntList.add(DnaCnt(lastCnt.A, lastCnt.C+1, lastCnt.G))
            'G' -> cntList.add(DnaCnt(lastCnt.A, lastCnt.C, lastCnt.G+1))
            else -> {
                cntList.add(DnaCnt(lastCnt.A, lastCnt.C, lastCnt.G))
            }
        }
    }

    for (i in 0 until ans.size) {
        val lastCnt = if (P[i] == 0) DnaCnt(0,0,0) else cntList[P[i]-1]
        val target = cntList[Q[i]]
        when {
            target.A-lastCnt.A > 0 -> ans[i] = 1
            target.C-lastCnt.C > 0 -> ans[i] = 2
            target.G-lastCnt.G > 0 -> ans[i] = 3
            else -> ans[i] = 4
        }
    }

    return ans
}

