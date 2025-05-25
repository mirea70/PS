package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1149 {
    private static int[][] dp;
    private static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        cost = new int[N+1][3];
        dp = new int[N+1][3];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<3; i++) {
            dp[1][i] = cost[1][i];
        }

        for(int i=0; i<3; i++) {
            dp[N][i] = getMinCost(N, i);
        }

        System.out.print(Math.min(Math.min(dp[N][0], dp[N][1]), Math.min(dp[N][1], dp[N][2])));
    }

    private static int getMinCost(int N, int color) {
        // dp 값이 0이 아니라면 바로 반환
        if(dp[N][color] != 0)
            return dp[N][color];
        // 없다면
        switch (color) {
            // dp[N][빨] = cost[N] + dp[N-1][초] + dp[N-1][파]
            case 0 : {
                return dp[N][color] = cost[N][color] + Math.min(getMinCost(N-1, 1), getMinCost(N-1, 2));
            }
            // dp[N][초] = cost[N] + dp[N-1][빨] + dp[N-1][파]
            case 1 : {
                return dp[N][color] = cost[N][color] + Math.min(getMinCost(N-1, 0), getMinCost(N-1, 2));
            }
            // dp[N][파] = cost[N] + dp[N-1][초] + dp[N-1][빨]
            case 2 : {
                return dp[N][color] = cost[N][color] + Math.min(getMinCost(N-1, 1), getMinCost(N-1, 0));
            }
            default: return -1;
        }
    }
}
