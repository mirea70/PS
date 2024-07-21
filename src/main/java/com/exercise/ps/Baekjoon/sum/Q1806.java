package com.exercise.ps.Baekjoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int min = Integer.MAX_VALUE;
        // 누적합 저장
        int[] total_sum = new int[n+1];
        String[] input2 = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            total_sum[i] = total_sum[i-1] + Integer.parseInt(input2[i-1]);
        }

        // start = 1 기준으로 차례로 부분합을 확인해간다.
        for(int start=1; start<=n; start++) {
            int end = start;
            while(end < n && total_sum[end] - total_sum[start-1] < s) {
                end++;
            }

            if(total_sum[end] - total_sum[start-1] >= s) {
                min = Math.min(min, end - start + 1);
            }
        }
        if(min == Integer.MAX_VALUE) min = 0;
        System.out.print(min);
    }
}
