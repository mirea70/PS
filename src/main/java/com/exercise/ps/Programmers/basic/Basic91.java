package com.exercise.ps.Programmers.basic;

public class Basic91 {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0; i< queries.length; i++) {
            exchange(arr, queries[i][0], queries[i][1]);
        }

        return arr;
    }

    private void exchange(int[] src, int idx1, int idx2) {
        int temp = src[idx1];
        src[idx1] = src[idx2];
        src[idx2] = temp;
    }
}
