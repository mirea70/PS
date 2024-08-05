package main.java.com.exercise.ps.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class Climbing {
    Map<Integer,Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        return rec(n);
    }

    private int rec(int k) {
        if(k == 1) return 1;
        if(k == 2) return 2;
        if(map.containsKey(k)) return map.get(k);
        map.put(k, rec(k-1) + rec(k-2));
        return map.get(k);
    }
}
