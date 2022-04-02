package googlecodejam.y2022.qr

import java.util.*


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val T = scanner.nextInt()

    for (t in 1..T) {
        val R = scanner.nextInt()
        val C = scanner.nextInt()
        val solution = solve(R, C)
        println("Case #$t:\n$solution")
    }
}

fun solve(R: Int, C: Int): String {
    val len = (R*2+1)*(C*2+2)-1

    val sb = StringBuilder()
    for (i in 1..len) {
        when {
            i == 1 || i == 2 || i == (C*2+3) || i == (C*2+4) -> sb.append(".")
            i%(C*2+2) == 0 -> sb.append("\n")
            (i/(C*2+2))%2 == 0 -> if (i%2 == 1) sb.append("+") else sb.append("-")
            (i/(C*2+2))%2 == 1 -> if (i%2 == 1) sb.append("|") else sb.append(".")
        }
    }
    return sb.toString()
}