package googlecodejam.y2020.r1c

import java.util.*

fun main() {
  val scanner = Scanner(System.`in`)
  val T = scanner.nextInt()

  for (t in 1..T) {
    val N = scanner.nextInt()
    val D = scanner.nextInt()

    val A = arrayOfNulls<Int>(N)
    for (i in 0 until N) {
      A[i] = scanner.nextInt()
    }
  }
}