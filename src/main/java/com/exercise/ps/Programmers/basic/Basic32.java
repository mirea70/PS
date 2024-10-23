package com.exercise.ps.Programmers.basic;

import java.util.Arrays;

public class Basic32 {
    public int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n-1, num_list.length);
    }
}
