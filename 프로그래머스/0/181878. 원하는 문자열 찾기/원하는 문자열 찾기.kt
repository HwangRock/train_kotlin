class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        var my=myString.uppercase()
        var p=pat.uppercase()
        
        val len1=my.length;
        val len2=p.length;
        
        for(i in 0..len1-1){
            if(i+len2-1>len1-1){
                break;
            }
            var str=my.substring(i,i+len2)
            if(str==p){
                answer=1;
                break;
            }
        }
        
        return answer
    }
}