package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579_2 {
    public static void main(String[] args) throws IOException {
        // 1 : 10
        // 2 : 20
        // 3 : 현재값 + 직전 | 전전 중 최대값
        // 스택이 약 300번 이루어지므로 Top-Down으로 풀면 스택오버플로우 발생
        // -> Bottom-Up DP
        // 25
        // 45
        // 35
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] src_arr = new int[N+1];
        for(int i=1; i<=N; i++)
            src_arr[i] = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[1] = src_arr[1];
        if(N >= 2) {
            dp[2] = src_arr[2] + src_arr[1];
        }
        for(int num=3; num<=N; num++)
            updateDp(dp, num, src_arr);
        System.out.print(dp[N]);
    }

    private static void updateDp(int[] dp, int n, int[] src_arr) {
        if(dp[n] != 0) return;

        dp[n] = Math.max(dp[n-2], dp[n-3] + src_arr[n-1]) + src_arr[n];
    }
}
