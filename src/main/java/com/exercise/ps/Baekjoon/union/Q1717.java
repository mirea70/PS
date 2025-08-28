package com.exercise.ps.Baekjoon.union;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1717 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = i;
        }

        while(m--> 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case 0: {
                    union(a, b);
                }
                break;
                case 1: {
                    System.out.println(isSameType(a, b) ? "yes" : "no");
                }
            }
        }
    }

    private static boolean isSameType(int a, int b) {
        return find(a) == find(b);
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot <= bRoot) {
            arr[bRoot] = aRoot;
        }
        else {
            arr[aRoot] = bRoot;
        }
    }

    private static int find(int val) {
        if(arr[val] != val) {
             arr[val] = find(arr[val]);
        }
        return arr[val];
    }
}
