package googlecodejam.y2020.qr

import java.util.Scanner

fun main(args: Array<String>) {
  val scanner = Scanner(System.`in`)
  val T = scanner.nextInt()

  for (t in 1..T) {
    val N = scanner.nextInt()
    var k = 0
    var r = 0
    var c = 0
    var duplicated: Boolean
    val map = mutableMapOf<Pair<Int, Int>, Int>()

    for(row in 0 until N) {
      val checkRowArray = IntArray(N)
      duplicated = false
      for(col in 0 until N) {
        val v = scanner.nextInt()
        if(row == col) k += v
        if(checkRowArray[v-1] != 0) duplicated = true
        checkRowArray[v-1] = 1
        map[Pair(col, v-1)] = 1
      }
      if(duplicated) r++
    }

    for(col in 0 until N) {
      for(row in 0 until N) {
        if(!map.containsKey(Pair(col, row))) {
          c++
          break
        }
      }
    }

    println("Case #$t: $k $r $c")
  }

}
