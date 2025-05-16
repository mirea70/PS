package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N+1];
            if(N >= 1) dp[1] = 1;
            if(N >= 2) dp[2] = 2;
            if(N >= 3) dp[3] = 4;

            for(int j=4; j<=N; j++) {
                updateDp(dp, j);
            }
            System.out.println(dp[N]);
        }
    }

    private static void updateDp(int[] dp, int N) {
        // 1: 1 : 1개
        // 2: 1+1, 2 : 2개
        // 3: 1+1+1, 1+2, 2+1, 3 4개
        // 4 : (1+1+1+1, 1+2+1, 2+1+1, 3+1), (1+1+2, 2+2), (1+3) 7개
        // 5 : (1+1+1+1+1, 1+2+1+1, 2+1+1+1, 3+1+1, 1+1+2+1, 2+2+1, 1+3+1), (1+1+1+2, 1+2+2, 2+1+2, 3+2), (1+1+3, 2+3) 13개
        // N : (N-1) + (N-2) + (N-3)
        if(dp[N] != 0) return;
        dp[N] = dp[N-1] + dp[N-2] + dp[N-3];
    }
}
