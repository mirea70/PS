package com.exercise.ps.Programmers.basic;

public class Basic79 {
    public int solution(int[][] arr) {
        int r_len = arr.length;
        int c_len = arr[0].length;

        for(int r=0; r<r_len; r++) {
            for(int c=0; c<c_len; c++) {
                if(arr[r][c] != arr[c][r])
                    return 0;
            }
        }

        return 1;
    }
}
