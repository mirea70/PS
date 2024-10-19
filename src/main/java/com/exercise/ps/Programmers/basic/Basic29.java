package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic29 {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<num_list.length; i = i + n) {
            list.add(num_list[i]);
        }

        return list.stream().mapToInt(i-> i).toArray();
    }
}
