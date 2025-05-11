package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        // dp 배열 초기화
        if(N >= 2) dp[2] = 1;
        if(N >= 3) dp[3] = 1;

        for(int num=2; num<=N; num++) {
            updateDp(dp, num);
        }
        // dp[N] 출력
        System.out.print(dp[N]);
    }

    private static void updateDp(int[] dp, int N) {
        if(dp[N] != 0) return;

        int a1 = Integer.MAX_VALUE;
        int a2 = Integer.MAX_VALUE;
        int a3 = Integer.MAX_VALUE;

        // 3으로 나눠지면 : N/3 인덱스 + 1
        if(N % 3 == 0) {
            a1 = dp[N/3] + 1;
        }
        // 2로 나눠지면 : N/3 인덱스 + 1
        if(N % 2 == 0) {
            a2 = dp[N/2] + 1;
        }
        // 직전 DP에 + 1
        a3 = dp[N-1] + 1;

        // 세 경우중 최솟값 갱신
        int tmp = Math.min(a1, a2);
        dp[N] = Math.min(tmp, a3);
    }
}
