package com.exercise.ps.Programmers.basic;

public class Basic34 {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;

        if(flag)
            answer = a+b;
        else
            answer = a-b;

        return answer;
    }
}
