class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        when(s.length){
            4, 6 -> answer = s.all{it.isDigit()}
            else -> answer = false
        }
        return answer
    }
}