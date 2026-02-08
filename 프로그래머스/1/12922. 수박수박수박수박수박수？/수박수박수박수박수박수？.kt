class Solution {
    fun solution(n: Int): String {
    var s = ""

    for (i in 0 until n) {
        if (i % 2 == 0) s += "수"
        else s += "박"
    }

    return s
    }
}