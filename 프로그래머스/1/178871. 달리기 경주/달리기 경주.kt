import java.util.*

class Solution {
    companion object {
        val seq: HashMap<String, Int> = HashMap()
    }

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        // 시뮬레이션 - callings가 호출됐을 때 players에서 이전과 현재를 전환
        // 선수 이름 - 순위 매칭, 순위 - 선수이름 매칭이 필요

        val fin = players.size
        for (i in 0 until fin) {
            seq[players[i]] = i
        }

        val len = callings.size
        for (i in 0 until len) {
            val cur = callings[i]
            val curPlayer = seq[cur]!!
            val front = players[curPlayer - 1]

            players[curPlayer - 1] = cur
            players[curPlayer] = front

            seq[cur] = curPlayer - 1
            seq[front] = curPlayer
        }

        return players
    }
}