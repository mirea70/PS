package com.exercise.ps.Baekjoon.combination;

import java.util.*;
import java.io.*;
public class Q15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = i+1;
        }
        boolean[] visit = new boolean[N];

        combi(arr, visit, 0, 0, r);
    }

    private static void combi(int[] arr, boolean[] visit, int start, int depth, int r) {
        if(depth == r) {
            for(int i=0; i<arr.length; i++) {
                if(visit[i]) System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combi(arr, visit, i+1, depth + 1, r);
                visit[i] = false;
            }
        }
    }
}
