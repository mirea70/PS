package main.java.com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010 {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(combi(M, N));
        }
        br.close();
    }

    private static int combi(int n, int r) {

        if(dp[n][r] != 0) return dp[n][r];
        else if(n == r || r == 0) return 1;
        else return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }
}
