package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MR10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }



        while(M--> 0) {

            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());

            int temp = arr[target1];
            arr[target1] = arr[target2];
            arr[target2] = temp;

        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
