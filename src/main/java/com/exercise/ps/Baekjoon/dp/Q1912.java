package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        // 누적합
        for(int i=1; i<=N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        // 현재까지 최대 조합 합을 가지고 있는 dp 배열 생성
        int[] dp = new int[N+1];
        // 현재까지 최소 누적합 rdp
        int[] rdp = new int[N+1];
        dp[0] = 0;
        dp[1] = arr[1];
        rdp[1] = Math.min(rdp[0], arr[1]);
        // 배열 순회x
        for(int i=2; i<=N; i++) {
            dp[i] = Math.max(dp[i-1], arr[i] - rdp[i-1]);
            rdp[i] = Math.min(rdp[i-1], arr[i]);
        }
        System.out.print(dp[N]);
    }
}
