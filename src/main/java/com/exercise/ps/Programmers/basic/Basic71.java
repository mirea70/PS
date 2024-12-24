package com.exercise.ps.Programmers.basic;

public class Basic71 {
    public int solution(int a, int b) {
        int answer = 0;
        // a, b 홀수라면
        if(a % 2 != 0 && b % 2 != 0) {
            answer = a*a + b*b;
        }
        // a,b 홀수 아니라면
        else if(a % 2 == 0 && b % 2 == 0) {
            answer = Math.abs(a-b);
        }
        // 하나만 홀수라면
        else {
            answer = 2 * (a+b);
        }
        return answer;
    }
}
