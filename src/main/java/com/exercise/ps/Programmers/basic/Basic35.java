package com.exercise.ps.Programmers.basic;

public class Basic35 {
    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num-end_num+1];

        for(int i=0; i<answer.length; i++) {
            if(start_num < end_num) break;
            answer[i] = start_num--;
        }

        return answer;
    }
}
