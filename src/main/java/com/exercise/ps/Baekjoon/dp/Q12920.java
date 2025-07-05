package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int cnt = 1;
            while(k > 0) {
                int use = Math.min(cnt, k);
                int weight = v * use;
                int value = c * use;

                for (int j=M; j>=weight; j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + value);
                }

                k -= use;
                cnt <<= 1;
            }
        }

        System.out.print(dp[M]);
    }
}
