package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // MCN 을 기억하는 dp
            int[][] dp = new int[M+1][N+1];

            System.out.println(combination(M, N, dp));
        }
    }

    private static int combination(int n, int r, int[][] dp) {
        if(dp[n][r] != 0) return dp[n][r];
        if(r == n || r == 0) return 1;
        return dp[n][r] = combination(n-1, r-1, dp) + combination(n-1, r, dp);
    }
}
