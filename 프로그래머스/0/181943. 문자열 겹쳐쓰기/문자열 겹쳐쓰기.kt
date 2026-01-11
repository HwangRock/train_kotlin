class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = ""
        
        var sb=StringBuilder()
        val len=my_string.length;
        val fin=overwrite_string.length;
        
        for(i in 0..len-1){
            if(s<= i && i<s+fin){
                sb.append(overwrite_string[i-s])
            }
            else{
                sb.append(my_string[i])
            }
        }
        answer=sb.toString()
        return answer
    }
}