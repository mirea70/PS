package com.exercise.ps.Programmers.basic;

public class Basic72 {
    public int solution(int[] num_list, int n) {
        for(int num : num_list) {
            if(num == n)
                return 1;
        }

        return 0;
    }
}
