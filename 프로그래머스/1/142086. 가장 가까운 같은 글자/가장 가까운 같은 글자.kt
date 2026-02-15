class Solution {
    fun solution(s: String): IntArray {
        val answer = IntArray(s.length) { -1 }
        s.forEachIndexed { index, c ->
            for ( i in index -1 downTo 0){
                if(s[i] == c){
                    answer[index] = index - i
                    break
                }
            }
        }
        return answer
    }
}