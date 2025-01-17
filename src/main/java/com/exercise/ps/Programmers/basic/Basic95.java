package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic95 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int len = num_list.length;

        switch (n) {
            case 1: return slice(num_list, 0, b, 1);
            case 2: return slice(num_list, a, len-1, 1);
            case 3: return slice(num_list, a, b, 1);
            case 4: return slice(num_list, a, b, c);
        }

        return new int[]{};
    }

    private int[] slice(int[] src, int s, int e, int interval) {
        List<Integer> list = new ArrayList<>();
        for(int i=s; i<=e; i=i+interval) {
            list.add(src[i]);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
