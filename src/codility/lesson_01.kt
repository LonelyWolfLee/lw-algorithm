package codility

fun main() {
    assert(solution(32)==0)
}

fun solution(N: Int): Int {

    val str = Integer.toBinaryString(N)
    var arr = str.split("1").map { seq -> seq.length};
    if (str.last() == '0') {
        arr = arr.dropLast(1);
    }

    return arr.max()!!

}