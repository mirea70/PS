package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] total_sum = new int[N+1];
        st = new StringTokenizer(br.readLine());
        // 1번 ~ N번 까지의 누적합 저장
        for(int i=1; i<=N; i++) {
            total_sum[i] = total_sum[i-1] + Integer.parseInt(st.nextToken());
        }
        // 1번부터 이중순회하며 구간합마다 M과 일치여부 확인 후 카운트
        int count = 0;
        for(int i=1; i<=N; i++) {
            for(int j=i; j<=N; j++) {
                int val = total_sum[j] - total_sum[i-1];
                if(val == M) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
