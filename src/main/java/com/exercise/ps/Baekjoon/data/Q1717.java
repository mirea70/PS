package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1717 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        parent = new int[n+1];
        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }
        for(int i=0; i<m; i++) {
            String[] arr = br.readLine().split(" ");
            int val = Integer.parseInt(arr[0]);
            int x = Integer.parseInt(arr[1]);
            int y = Integer.parseInt(arr[2]);
            if(val == 0) {
                union(x, y);
            }
            else {
                System.out.println(isSameParent(x,y) ? "YES" : "NO");
            }
        }

    }

    private static int find(int x) {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x==y;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x < y) {
                parent[y] = x;
            }
            else {
                parent[x] = y;
            }
        }
    }
}
