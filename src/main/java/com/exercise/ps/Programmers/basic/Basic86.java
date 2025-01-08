package com.exercise.ps.Programmers.basic;

import java.util.ArrayList;
import java.util.List;

public class Basic86 {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i : arr)
            list.add(i);


        while(!isPowerOf2(list.size())) {
            list.add(0);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    private boolean isPowerOf2(int len) {
        int cur = 1;

        while(cur <= len) {
            if(cur == len)
                return true;

            cur *= 2;
        }

        return false;
    }
}
