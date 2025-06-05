package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1932 {
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        int[][] org = new int[N+1][];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            org[i] = new int[i+1];
            for(int j=1; j<=i; j++) {
                org[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Integer[][] dp = new Integer[N+1][];
        dp[1] = new Integer[2];
        dp[1][1] = org[1][1];
        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, getDp(dp, org, N, i));
        }
        System.out.print(max);
    }

    private static int getDp(Integer[][] dp, int[][] org, int row, int col) {
        // 이미 있을 경우 그 값 반환
        if(dp[row] != null && dp[row][col] != null) return dp[row][col];

        dp[row] = new Integer[row+1];
        // 맨 왼쪽일 경우
        if(col == 1) {
            return dp[row][col] = getDp(dp, org, row-1, col) + org[row][col];
        }
        // 맨 오른쪽일 경우
        else if(col == row) {
            return dp[row][col] = getDp(dp, org, row-1, col-1) + org[row][col];
        }
        // 중간일 경우
        else {
            int l = getDp(dp, org, row-1, col-1);
            int r = getDp(dp, org, row-1, col);
            return  dp[row][col] = Math.max(l, r) + org[row][col];
        }
    }
}
