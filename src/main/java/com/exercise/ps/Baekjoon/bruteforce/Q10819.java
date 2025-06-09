package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10819 {
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(arr, new boolean[N], new int[N], 0);

        System.out.print(max);
    }

    // N개만큼 뽑는 순열
    public static void perm(int[] arr, boolean[] visit, int[] current, int depth) {
        if(depth == arr.length) {
            int sum = 0;
            for(int i=0; i<current.length-1; i++) {
                sum += Math.abs(current[i] - current[i+1]);
            }
            max = Math.max(max, sum);
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
