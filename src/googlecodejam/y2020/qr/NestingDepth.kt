package googlecodejam.y2020.qr

fun main(args: Array<String>) {
  val T = readLine()!!.toInt()

  for (t in 1..T) {
    val res = nestingDepth(readLine()!!)
    println("Case #$t: $res")
  }
}

fun nestingDepth(problem: String):String {
  val sb = StringBuffer()
  var pos = 0
  if(problem.length == 1) return sb.append(simpleDepth(problem, 0, 0)).toString()

  for(i in problem.indices) {
    if(i > pos && problem[i] < problem[i-1]) {
      sb.append(simpleDepth(problem.substring(pos, i), if(pos==0) 0 else toInt(problem[pos]), toInt(problem[i])))
      pos = i
    }
  }
  sb.append(simpleDepth(problem.substring(pos, problem.length), if(pos==0) 0 else toInt(problem[pos]), 0))

  return sb.toString()
}

fun simpleDepth(simple: String, start: Int, end: Int): String {
  val sb = StringBuffer()
  var count = start

  simple.forEach {
    val n = toInt(it)
    for(i in count until n) sb.append("(")
    count = n
    sb.append(it)
  }

  for(i in 0 until count - end) sb.append(")")

  return sb.toString()
}

fun toInt(c: Char): Int = c.toInt() - 48