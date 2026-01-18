class Solution {

    fun solution(n: Int): Array<IntArray> {
        val answer = Array(n) { IntArray(n) }

        var state = 0
        var y = 0
        var x = 0

        for (i in 1..(n * n)) {
            answer[y][x] = i

            when (state) {
                0 -> {
                    x++
                    if (x >= n || answer[y][x] > 0) {
                        x--
                        y++
                        state = 1
                    }
                }
                1 -> {
                    y++
                    if (y >= n || answer[y][x] > 0) {
                        y--
                        x--
                        state = 2
                    }
                }
                2 -> {
                    x--
                    if (x < 0 || answer[y][x] > 0) {
                        x++
                        y--
                        state = 3
                    }
                }
                else -> { // ↑
                    y--
                    if (y < 0 || answer[y][x] > 0) {
                        y++
                        x++
                        state = 0
                    }
                }
            }
        }

        return answer
    }
}
