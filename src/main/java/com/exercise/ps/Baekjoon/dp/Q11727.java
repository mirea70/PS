package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 점화식 : dp(n) = dp(n-1) + 2 * dp(n-2)
        int[] dp = new int[N+1];
        dp[1] = 1;
        if(N >= 2) {
            dp[2] = 3;
        }

        for(int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.print(dp[N]);
    }
}
