package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic46 {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = Arrays.copyOfRange(num_list, 0, len+1);

        if(num_list[len-1] > num_list[len-2]) {
            answer[len] = num_list[len-1] - num_list[len-2];
        }
        else
            answer[len] = num_list[len-1]*2;

        return answer;
    }
}
