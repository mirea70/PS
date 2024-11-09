package com.exercise.ps.Programmers.basic;

public class Basic49 {
    public int solution(int a, int b) {

        int res1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int res2 = Integer.parseInt(String.valueOf(b) + String.valueOf(a));

        int answer = 0;
        if(res1 >= res2)
            answer = res1;
        else
            answer = res2;
        return answer;
    }
}
