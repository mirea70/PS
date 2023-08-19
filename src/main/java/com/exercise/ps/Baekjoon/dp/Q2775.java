package com.exercise.ps.Baekjoon.dp;

import java.util.Scanner;

public class Q2775 {

    static int[][] dp = new int[15][15];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            System.out.println(rec(k,n));
        }
    }

    private static int rec(int k, int n) {
        if(k == 0) return n;
        if(dp[k][n] != 0) return dp[k][n];

        int sum = 0;
        for(int i=1; i<=n; i++) {
            sum += rec(k-1, i);
        }
        return dp[k][n] = sum;

    }
}
