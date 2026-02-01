import java.util.*

class Solution {

    fun makeDay(date: String): Int {
        val ymd = date.split(".")
        val y = ymd[0].toInt()
        val m = ymd[1].toInt()
        val d = ymd[2].toInt()

        return 12 * 28 * y + 28 * m + d
    }

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val lis: MutableList<Int> = ArrayList()
        // 년*10000+달*100+일 로 구분한다.
        // 현재 일이 1인데 빼야하는 경우에는 달 -1을 하고 일을 28일로 한다.
        // 현재 달이 1인데 빼야하는 경우에는 년 -1을 하고 달을 12로 한다.
        // 현재날짜(숫자)와 비교해서 더 작다면 answer에 넣는다.

        val cur = makeDay(today)

        val map: HashMap<Char, Int> = HashMap()
        for (s in terms) {
            val ss = s.split(" ")
            val c = ss[0][0]
            val valInt = ss[1].toInt()
            map[c] = valInt
        }

        var seq = 1
        for (s in privacies) {
            val parse = s.split(" ")
            var day = makeDay(parse[0])
            val c = parse[1][0]
            val plus = map[c]!! * 28

            day = day + plus - 1

            if (cur > day) {
                lis.add(seq)
            }
            seq++
        }

        val answer = lis.map { it }.toIntArray()
        return answer
    }
}