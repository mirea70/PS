package com.exercise.ps.Baekjoon.tp;

import java.util.*;
import java.io.*;

public class Q2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        // 포인터 s와 e 설정
        int s = 0;
        int e = s + K-1;
        int sum;

        while(e < N) {
            sum = 0;
            for(int i = s; i<=e; i++) {
               sum += arr[i];
            }
            max = Math.max(max, sum);
            s++;
            e++;
        }

        System.out.println(max);

    }
}
