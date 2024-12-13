package com.exercise.ps.Programmers.basic;

public class Basic60 {
    public int solution(int[] arr, int idx) {
        for(int i=idx; i<arr.length; i++) {
            if(arr[i] == 1)
                return i;
        }

        return -1;
    }
}
