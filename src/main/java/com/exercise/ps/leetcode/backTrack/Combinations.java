package com.exercise.ps.leetcode.backTrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // 1234
        int[] numbers = new int[n+1];
        for(int i=1; i<=n; i++) {
            numbers[i] = i;
        }
        combi(numbers, new ArrayList<Integer>(), 1, k, 1);
        return list;
    }

    private void combi(int[] numbers, List<Integer> current, int depth, int k, int start) {
        if(depth == k+1) {
            list.add(current);
            return;
        }

        for(int i=start; i<numbers.length; i++) {
            List<Integer> newCurrent = new ArrayList<>();
            newCurrent.addAll(current);
            newCurrent.add(numbers[i]);
            combi(numbers, newCurrent, depth+1, k, i+1);
        }
    }
}
