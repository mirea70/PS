package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11053 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N= Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] dp = new Integer[N+1];
        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, getDpVal(dp, i));
        }
        System.out.print(max);
    }

    // 증가하는 부분 수열 구해서 갱신하기
    private static int getDpVal(Integer[] dp, int N) {
        if(dp[N] == null) {
            dp[N] = 1;
            // N-1부터 1번까지 현재값보다 작은 것을 찾으면 재귀값+1과 현DP값 중 큰 값으로 갱신
            for (int i = N - 1; i > 0; i--) {
                if (arr[i] < arr[N]) {
                    dp[N] = Math.max(dp[N], getDpVal(dp, i) + 1);
                }
            }
        }

        return dp[N];
    }
}
