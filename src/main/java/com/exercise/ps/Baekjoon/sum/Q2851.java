package com.exercise.ps.Baekjoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 누적합 저장
        int[] totalSum = new int[11];
        for(int i=1; i<=10; i++) {
            totalSum[i] = totalSum[i-1] + Integer.parseInt(br.readLine());
        }
        // 누적합 역으로 순회하며 100과의 차이가 현재보다 적을 경우 저장
        int min_dif = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=10; i>0; i--) {
            int dif = Math.abs(100-totalSum[i]);
            if(dif < min_dif) {
                // 차이값, 그때의 누적값을 각각 저장
                min_dif = dif;
                ans = totalSum[i];
            }
        }
        // 순회 끝
        // 100과 가장 차이 적은 누적값 출력
        System.out.print(ans);
    }
}
