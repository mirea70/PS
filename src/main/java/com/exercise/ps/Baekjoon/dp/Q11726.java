package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        if(N >=2) dp[2] = 2;

        for(int num=3; num<=N; num++) {
            dp[num] = (dp[num-1] + dp[num-2]) % 10007;
        }

        System.out.print(dp[N]);
    }
}
