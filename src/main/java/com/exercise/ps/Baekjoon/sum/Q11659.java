package com.exercise.ps.Baekjoon.sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sum_arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        sum_arr[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=N; i++) {
            sum_arr[i] = sum_arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println(sum_arr[r] - sum_arr[l-1]);
        }
    }
}
