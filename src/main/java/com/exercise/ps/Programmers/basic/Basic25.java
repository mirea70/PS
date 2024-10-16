package com.exercise.ps.Programmers.basic;

public class Basic25 {
    public int solution(int[] numbers, int n) {
        int answer = 0;

        for(int num : numbers) {
            if(answer > n) break;

            answer += num;
        }

        return answer;
    }
}
