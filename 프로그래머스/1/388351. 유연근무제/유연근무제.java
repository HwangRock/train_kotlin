class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        // 현재에 맞는 것을 빼옴
        int fin=schedules.length;
        for(int i=0;i<fin;i++){
            int target=schedules[i]+10;
            if(target%100>=60){
                target+=40;
            }
            int point=0;
            for(int j=0;j<7;j++){
                if(startday != 6 && startday != 7 && timelogs[i][j]<=target){
                    point++;
                }
                startday++;
                if(startday==8){
                    startday=1;
                }
            }
            if(point==5){
                answer++;
            }
        }
        // 지금 목표 시간에서 분 +10을 하는데, 60을 넘기면 +100, -60을 해줘야함
        // 요일은 % 7 +1 이 되야함
        // 토요일과 일요일이 아니라면 ans++
        
        return answer;
    }
}