class Solution {
    fun solution(s: String): String {
    
    var answer = s.toCharArray().sortedDescending().joinToString("")
    return answer
}
}