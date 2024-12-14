package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic61 {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=k; i<=n; i=i+k) {
            list.add(i);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
