class Solution {
    fun solution(number: IntArray): Int {
        var answer: Int = 0
        for(i in 0 until number.size - 2){
            for(j in (i + 1) until number.size - 1){
                for(l in (j + 1) until number.size){
                    if(number[i] + number[j] + number[l] == 0) answer++
                }
            }
        }
        return answer
    }
}