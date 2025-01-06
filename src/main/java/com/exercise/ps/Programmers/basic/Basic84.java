package com.exercise.ps.Programmers.basic;

public class Basic84 {
    public int solution(int a, int d, boolean[] included) {
        int current = a;
        int answer = 0;
        if(included[0])
            answer = current;

        for(int i=1; i<included.length; i++) {
            current += d;
            if(included[i])
                answer += current;
        }

        return answer;
    }
}
