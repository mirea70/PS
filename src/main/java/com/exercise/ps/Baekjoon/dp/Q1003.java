package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            // 2차원 dp 생성 및 초기화
            int[][] dp = new int[N+1][2];
            dp[0][0] = 1;
            dp[0][1] = 0;

            if(N >= 1) {
                dp[1][0] = 0;
                dp[1][1] = 1;
            }

            for(int num=2; num<=N; num++)
                initDp(dp, num);
            // 초기화된 DP 값 그대로 출력
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    private static void initDp(int[][] dp, int N) {
        // 이미 있으면 그대로 반환
        if(dp[N][0] != 0 && dp[N][1] != 0) return;
        // dp[N] = dp[N-1] + dp[N-2]
        dp[N][0] = dp[N-1][0] + dp[N-2][0];
        dp[N][1] = dp[N-1][1] + dp[N-2][1];
    }
}
