package com.exercise.ps.Programmers.basic;

import java.util.HashMap;
import java.util.Map;

public class Basic92 {
    public int solution(String[] strArr) {
        int maxCntKey = 0;
        int maxCnt = 0;
        Map<Integer, Integer> lenMap = new HashMap<>();

        for(int i=0; i< strArr.length; i++) {
            int curLen = strArr[i].length();
            lenMap.put(curLen, lenMap.getOrDefault(curLen, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : lenMap.entrySet()) {
            System.out.println(entry.toString());

            if(entry.getValue() >= maxCnt) {
                maxCnt = entry.getValue();
                maxCntKey = entry.getKey();
            }
        }

        return maxCntKey;
    }
}
