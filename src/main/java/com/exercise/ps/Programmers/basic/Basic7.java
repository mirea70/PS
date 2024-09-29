package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic7 {
    public int[] solution(int[] num_list) {
        int[] answer = {};

        Arrays.sort(num_list);
        answer = Arrays.copyOfRange(num_list, 0, 5);

        return answer;
    }
}
