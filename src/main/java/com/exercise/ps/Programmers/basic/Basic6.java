package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic6 {
    public int[] solution(int[] num_list) {
        int[] answer = {};

        Arrays.sort(num_list);
        answer = Arrays.copyOfRange(num_list, 5, num_list.length);

        return answer;
    }
}
