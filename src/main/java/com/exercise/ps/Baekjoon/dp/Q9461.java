package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;

        for(int t=0; t<T; t++) {
            System.out.println(getDp(dp, Integer.parseInt(br.readLine())));
        }
    }

    private static long getDp(long[] dp, int n) {
        if(dp[n] != 0) return dp[n];

        return dp[n] = getDp(dp, n-1) + getDp(dp, n-5);
    }
}
