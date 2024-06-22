package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=10; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int cnt = 0;
            for(int j=2; j<n-2; j++) {
                int max = 0;
                // 좌로 2보, 우로 2보까지 최댓값 구한다.
                for(int k=j-2; k<=j+2; k++) {
                    if(j == k) continue;
                    max = Math.max(arr[k], max);
                }
                // 그 최댓값 < 현재값 일경우
                // cnt += 현재값 - 최대값
                if(max <arr[j]) cnt+= arr[j] - max;

            }
            System.out.println("#" + i + " " + cnt);
        }
    }
}
