package com.exercise.ps.Programmers.basic;

public class Basic77 {
    public int solution(int[][] board, int k) {
        int answer = 0;
        int r_len = board.length;
        int c_len = board[0].length;

        for(int r=0; r< r_len; r++) {
            for(int c=0; c< c_len; c++) {
                if(r + c <= k)
                    answer += board[r][c];
            }
        }
        return answer;
    }
}
