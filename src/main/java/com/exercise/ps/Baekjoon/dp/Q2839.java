package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp_arr = new int[5001];
        dp_arr[3] = 1;
        dp_arr[4] = -1;
        dp_arr[5] = 1;
        dp_arr[6] = 2;
        dp_arr[7] = -1;

        for(int num=8; num<=N; num++)
            update_dp(dp_arr, num);

        System.out.print(dp_arr[N]);
    }

    private static void update_dp(int[] dp_arr, int N) {
        if(dp_arr[N] != 0) return;

        // dp[n] = 최소값(dp[n-3], dp[n-5]) + 1 -> 두 값 모두 -1일 경우 취급 X
        if(dp_arr[N-3] == -1 && dp_arr[N-5] == -1) {
            dp_arr[N] = -1;
        }
        else if (dp_arr[N-3] == -1) {
            dp_arr[N] = dp_arr[N-5] + 1;
        }
        else if (dp_arr[N-5] == -1) {
            dp_arr[N] = dp_arr[N-3] + 1;
        }
        else {
            dp_arr[N] = Math.min(dp_arr[N-3], dp_arr[N-5]) + 1;
        }
    }
}
