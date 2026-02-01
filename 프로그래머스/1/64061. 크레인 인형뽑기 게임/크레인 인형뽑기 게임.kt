import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        // 시뮬레이션 - moves에서 수를 빼와서 board의 열에서 원소가 보일때까지 탐색
        // 바구니는 스택으로 지정

        val st: Deque<Int> = ArrayDeque()
        val n = board.size
        val fin = moves.size

        for (i in 0 until fin) {
            val row = moves[i]
            for (j in 0 until n) {
                if (board[j][row - 1] != 0) {
                    if (!st.isEmpty() && st.peek() == board[j][row - 1]) {
                        answer += 2
                        st.pop()
                    } else {
                        st.push(board[j][row - 1])
                    }
                    board[j][row - 1] = 0
                    break
                }
            }
        }
        return answer
    }
}