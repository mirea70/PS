package com.exercise.ps.Programmers.basic;

public class Basic8 {
    public int[] solution(int[] arr, int n) {
        int len = arr.length;

        for(int i=0; i<len; i++) {
            if(len % 2 != 0) {
                if(i % 2 == 0)
                    arr[i] += n;
            }
            else {
                if(i % 2 != 0)
                    arr[i] += n;
            }
        }

        return arr;
    }
}
