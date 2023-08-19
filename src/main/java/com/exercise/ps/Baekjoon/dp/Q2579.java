package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2579 {

    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            // 조합을 방문하면서 해당 계단을 올라갈때까지의 최댓값을 갱신해나가며 올라간다.
            // 즉, n번째 계단 오를때 마다, n계단 갈때까지의 dp 값을 갱신한다.
            int score = Integer.parseInt(br.readLine());
            dpUpdate(i, arr, score);
        }
        System.out.println(dp[N]);
    }

    private static void dpUpdate(int idx, int[] arr, int score) {
        if(dp[idx] != 0) return;

        if(idx == 0) {
            arr[idx] = score;
            dp[idx] = score;
            return;
        }

        if(idx == 1) {
            arr[idx] = score;
            dp[idx] = arr[idx] + arr[idx-1];
            return;
        }
        // 매번 계단을 오를때마다 idx-2번째~idx까지 2개 뽑는 조합을 방문하여 최댓값을 갱신한다.
        int result = combination(new int[]{arr[idx-2], arr[idx-1], arr[idx]}, new boolean[3], 0, 0, 2, 0);
        dp[idx] = Math.max(dp[idx-1], dp[idx-3] + result);
    }

    private static int combination(int[] arr, boolean[] visit, int start, int depth, int r, int max) {

        if(depth == r) {
            int sum = 0;
            for(int i=0; i< arr.length; i++) {
                sum += arr[i];
            }
            max = Math.max(max, sum);
            return max;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(arr, visit, i+1, depth+1, r, max);
                visit[i] = false;
            }
        }
        return 1;
    }
}
