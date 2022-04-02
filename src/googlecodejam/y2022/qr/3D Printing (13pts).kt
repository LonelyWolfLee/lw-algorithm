package googlecodejam.y2022.qr

import java.lang.Integer.min
import java.util.*

const val TARGET: Int = 1000000
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val T = scanner.nextInt()

    for (t in 1..T) {
        var c = TARGET
        var m = TARGET
        var y = TARGET
        var k = TARGET

        for (l in 1..3) {
            c = min(scanner.nextInt(), c)
            m = min(scanner.nextInt(), m)
            y = min(scanner.nextInt(), y)
            k = min(scanner.nextInt(), k)
        }

        println("Case #$t: ${solve(c, m, y, k)}")
    }
}

fun solve(c: Int, m: Int, y: Int, k: Int): String {
    return if (c+m+y+k < TARGET) "IMPOSSIBLE" else run {
        val sb = StringBuilder()
        if (c >= TARGET) sb.append("$TARGET 0 0 0")
        else {
            if (c + m >= TARGET) sb.append("$c ${TARGET - c} 0 0")
            else {
                if (c + m + y >= TARGET) sb.append("$c $m ${TARGET - (c+m)} 0")
                else sb.append("$c $m $y ${TARGET - (c+m+y)}")
            }
        }
        sb.toString()
    }
}