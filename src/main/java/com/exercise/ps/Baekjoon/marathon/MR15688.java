package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR15688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        int min = 1000001;
        for(int i=0; i<N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;

            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        int range = max - min + 1;
        int[] count_arr = new int[range];
        int[] count_total_sum = new int[range];

        for(int i=0; i<N; i++) {
            count_arr[arr[i] - min]++;
        }

        count_total_sum[0] = count_arr[0];
        for(int i=1; i<range; i++) {
            count_total_sum[i] = count_total_sum[i-1] + count_arr[i];
        }

        int[] ans = new int[N];
        for(int i=N-1; i>=0; i--) {
            int idx = count_total_sum[arr[i] - min]-- -1;
            ans[idx] = arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int num : ans) {
            sb.append(num).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
