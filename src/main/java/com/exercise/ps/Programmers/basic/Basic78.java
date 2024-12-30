package com.exercise.ps.Programmers.basic;

public class Basic78 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                answer[r][c] = r == c ? 1 : 0;
            }
        }
        return answer;
    }
}
