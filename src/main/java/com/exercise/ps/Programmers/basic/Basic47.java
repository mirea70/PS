package com.exercise.ps.Programmers.basic;

public class Basic47 {
    public int solution(int[] num_list) {

        long sum = 0;
        long mul = 1;

        for(int i : num_list)
            sum += i;

        for(int i : num_list)
            mul *= i;

        int answer = 0;
        if(mul < sum*sum)
            answer = 1;

        return answer;
    }
}
