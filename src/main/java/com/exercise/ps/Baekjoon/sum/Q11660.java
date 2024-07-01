package com.exercise.ps.Baekjoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        // i행 j열의 누적합을 각각 구하기
        int[][] total_sum = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=1; j<=n; j++) {
                total_sum[i][j] = total_sum[i][j-1] + Integer.parseInt(arr[j-1]);
            }
        }
        // m번 동안
        for(int i=1; i<=m; i++) {
            // 구간합을 구해 출력
            String[] input2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(input2[0]);
            int y1 = Integer.parseInt(input2[1]);
            int x2 = Integer.parseInt(input2[2]);
            int y2 = Integer.parseInt(input2[3]);

            int sum = 0;
            for(int j=x1; j<=x2; j++) {
                sum += total_sum[j][y2] - total_sum[j][y1-1];
            }
            System.out.println(sum);
        }
    }
}
