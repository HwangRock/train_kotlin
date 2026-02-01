class Solution {
    fun solution(s: String): Int {
        var answer = 0
        // 시뮬레이션 - 같은 문자 횟수, 다른 문자 횟수를 각각 저장
        // 2개의 숫자가 같으면 answer 증가, 횟수 초기화

        var sa = 0
        var dif = 0
        var c = ' '
        val fin = s.length

        for (i in 0 until fin) {
            if (sa == 0 && dif == 0) {
                c = s[i]
            }

            if (s[i] == c) {
                sa++
            } else {
                dif++
            }

            if (sa == dif) {
                answer++
                sa = 0
                dif = 0
            }
        }

        if (sa != dif) {
            answer++
        }

        return answer
    }
}