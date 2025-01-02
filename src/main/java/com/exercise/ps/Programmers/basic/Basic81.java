package com.exercise.ps.Programmers.basic;

public class Basic81 {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0; i< queries.length; i++) {
            executeQuery(arr, queries[i][0], queries[i][1]);
        }

        return arr;
    }

    private void executeQuery(int[] arr, int s, int e) {
        for(int i=s; i<=e; i++)
            arr[i] += 1;
    }
}
