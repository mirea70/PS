package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10974 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=1; i<=N; i++) {
            arr[i-1] = i;
        }
        perm(arr, new boolean[N], new int[N], 0);
        sb.setLength(sb.length()-1);
        System.out.print(sb.toString());
    }

    private static void perm(int[] arr, boolean[] visit, int[] current, int depth) {
        if(depth == arr.length) {
            for(int num : current) {
                sb.append(num).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = arr[i];
                perm(arr, visit, current, depth+1);
                visit[i] = false;
            }
        }
    }
}
