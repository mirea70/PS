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

        int[][] dp = new int[N+1][M+1];
        int[] v = new int[N+1];
        int[] c = new int[N+1];
        int[] k = new int[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            v[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            k[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                // 우선 이전값 그대로 가져오기
                dp[i][j] = dp[i-1][j];

                for(int l=1; l<=k[i]; l++) {
                    updateDp(dp, v[i], c[i], j, l, i);
                }
            }
        }
        System.out.print(dp[N][M]);
    }

    // 현재 물건을 k만큼 넣을 수 있을 때 dp 갱신
    private static void updateDp(int[][] dp, int cv, int cc, int weight, int k, int i) {
        if(k <= 0) return;

        if(weight - (cv * k) >= 0) {
            dp[i][weight] = Math.max(dp[i][weight], dp[i-1][weight - (cv * k)] + (cc * k));
        }
    }
}
