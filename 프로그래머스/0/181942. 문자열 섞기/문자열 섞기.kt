class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        
        val sb=StringBuilder()
        var fin=str1.length
        for(i in 0..fin-1){
            sb.append(str1[i])
            sb.append(str2[i])
        }
        answer=sb.toString()
        
        return answer
    }
}