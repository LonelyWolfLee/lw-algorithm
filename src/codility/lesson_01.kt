package codility

fun main() {
    assert(solutionBinaryGap(32)==0)
}

fun solutionBinaryGap(N: Int): Int {

    val str = Integer.toBinaryString(N)
    val arr = str.split("1").map { seq -> seq.length};
    return if (str.last() == '0') arr.dropLast(1).max()!!
    else arr.max()!!
}