package com.exercise.ps.Programmers.basic;

public class Basic89 {
    public int solution(int[] num_list) {
        int answer = 0;
        for (int j : num_list) {
            answer += getDevideCnt(j);
        }

        return answer;
    }

    private int getDevideCnt(int src) {
        int cnt = 0;
        while(src > 1) {
            if(src % 2 ==0) {
                src = src/2;
            }
            else {
                src = (src-1)/2;
            }
            cnt++;
        }

        return cnt;
    }
}
