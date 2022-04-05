package googlecodejam.y2022.qr

import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val T = scanner.nextInt()

    for (t in 1..T) {
        val N =scanner.nextInt()
        val array = ArrayList<Int>(N)
        for (i in 0 until N) {
            array.add(scanner.nextInt())
        }
        array.sort()

        println("Case #$t: ${solve(0, array)}")
    }
}

fun solve(len: Int, array: List<Int>): Int {
    val i = array.indexOfFirst { it > len }
    return if (i == -1) len else solve(len+1, array.drop(i+1))
}