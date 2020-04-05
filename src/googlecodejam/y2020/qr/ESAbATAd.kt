package googlecodejam.y2020.qr

fun main(args: Array<String>) {
  val env = readLine()!!.split(" ").map { it.toInt() }
  for (t in 1..env[0]) {
    if(!solve(env[1])) break
  }
}

fun solve(b: Int): Boolean {
  val current = IntArray(b)
  current.fill(-1)

  val sb = StringBuffer()
  for(i in 1..10) {
    println(i.toString())
    val j = readLine()!!
    if(j == "N") return false
    current[b/2 - 5 + i -1] = j.toInt()
  }
  if (b == 10) {
    current.sliceArray(0 until b).forEach { sb.append(it) }
    println(sb.toString())
    val j = readLine()!!
    return j == "Y"
  }

  return false
}