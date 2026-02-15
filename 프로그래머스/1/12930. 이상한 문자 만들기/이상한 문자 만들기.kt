class Solution {
    fun solution(s: String): String {
        var worlds = s.split(" ")
        var answer = ""
        for(i in 0 until worlds.size){
            for(j in 0 until worlds[i].length){
                if(j % 2 == 0)  answer += worlds[i][j].toUpperCase()
                else answer += worlds[i][j].toLowerCase()
            }
            if(i == worlds.size - 1) break
            answer += " "
        }
        return answer
    }
}