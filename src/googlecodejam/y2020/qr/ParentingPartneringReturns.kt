package googlecodejam.y2020.qr

fun main(args: Array<String>) {
  val T = readLine()!!.toInt()
  for (t in 1..T) {
    val N = readLine()!!.toInt()
    val activities = mutableListOf<Pair<Int, List<Int>>>()
    for (n in 1..N) activities.add(Pair(n, readLine()!!.split(" ").map { it.toInt() }))
    println("Case #$t: ${solve(activities.map { Pair(it.first, IntRange(it.second[0], it.second[1]-1)) })}")
  }
}

fun solve(ranges: List<Pair<Int, IntRange>>): String {
  val sb = StringBuffer()
  val sortedRange = ranges.sortedBy { it.second.count() }.sortedBy { it.second.first }
  val res = mutableListOf<Pair<Int, String>>()
  val cameron = IntArray(24*60)
  val jamie = IntArray(24*60)
  sortedRange.forEach { range: Pair<Int, IntRange> ->
    when {
      cameron.sliceArray(range.second).all { it == 0 } -> {
        cameron.fill(1, range.second.first, range.second.last + 1)
        res.add(Pair(range.first, "C"))
      }
      jamie.sliceArray(range.second).all { it == 0 } -> {
        jamie.fill(1, range.second.first, range.second.last + 1)
        res.add(Pair(range.first, "J"))
      }
      else -> return "IMPOSSIBLE"
    }
  }
  res.sortedBy { it.first }.forEach { sb.append(it.second) }
  return sb.toString()
}