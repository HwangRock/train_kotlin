class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer = 0

        val fin = schedules.size
        var day = startday

        for (i in 0 until fin) {
            var target = schedules[i] + 10
            if (target % 100 >= 60) {
                target += 40
            }

            var point = 0
            for (j in 0 until 7) {
                if (day != 6 && day != 7 && timelogs[i][j] <= target) {
                    point++
                }
                day++
                if (day == 8) {
                    day = 1
                }
            }

            if (point == 5) {
                answer++
            }
        }

        return answer
    }
}