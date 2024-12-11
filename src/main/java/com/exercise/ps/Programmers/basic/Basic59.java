package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic59 {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();

        for(int[] interval : intervals) {
            addInterval(list, interval, arr);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private void addInterval(List<Integer> list, int[] interval, int[] arr) {
        int start = interval[0];
        int end = interval[1];

        for(int i=start; i<=end; i++)
            list.add(arr[i]);
    }
}
