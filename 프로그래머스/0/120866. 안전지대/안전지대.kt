class Solution {

    companion object {
        val dy = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
        val dx = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
    }

    fun solution(board: Array<IntArray>): Int {
        var answer = 0
        val n = board.size

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 1) {
                    for (k in 0 until 8) {
                        val ny = i + dy[k]
                        val nx = j + dx[k]
                        if (ny in 0 until n && nx in 0 until n && board[ny][nx] == 0) {
                            board[ny][nx] = 2
                        }
                    }
                }
            }
        }

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (board[i][j] == 0) {
                    answer++
                }
            }
        }

        return answer
    }
}
