class Solution {

    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer = 0

        val h = HashMap<Int, Int>()
        h.merge(a, 1, Int::plus)
        h.merge(b, 1, Int::plus)
        h.merge(c, 1, Int::plus)
        h.merge(d, 1, Int::plus)

        val num = h.size

        if (num == 1) {
            answer = 1111 * a
        } 
        else if (num == 2) {
            var one = false
            var p = 0
            var q = 0
            var qq = 0
            var seq = 1

            for (i in h.keys) {
                if (h[i] == 1) {
                    one = true
                    qq = i
                }

                if (seq == 1) {
                    p = i
                } else {
                    q = i
                }
                seq++
            }

            if (!one) {
                answer = (p + q) * kotlin.math.abs(p - q)
            } else {
                if (p == qq) {
                    p = q
                }
                answer = (10 * p + qq) * (10 * p + qq)
            }
        } 
        else if (num == 3) {
            answer = 1
            for (i in h.keys) {
                if (h[i] == 1) {
                    answer *= i
                }
            }
        } 
        else {
            var mini = 10
            for (i in h.keys) {
                mini = kotlin.math.min(mini, i)
            }
            answer = mini
        }

        return answer
    }
}
