package com.exercise.ps.Programmers.basic;

public class basic48 {
    public int solution(int a, int b) {

        int res1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int res2 = 2*a*b;

        int answer = 0;
        if(res1>= res2)
            answer = res1;
        else
            answer = res2;
        return answer;
    }
}
