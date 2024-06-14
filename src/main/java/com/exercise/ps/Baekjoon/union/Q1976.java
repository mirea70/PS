package com.exercise.ps.Baekjoon.union;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1976 {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1; i<=n; i++)
            parent[i] = i;
        for(int i=1; i<=n; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j=0; j<arr.length; j++) {
                if(arr[j].equals("1")) {
                    union(i, j+1);
                }
            }
        }
        int[] plan = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int root = plan[0];
        String ans = "YES";
        for(int city : plan) {
            if(!isUnion(parent[root], parent[city]))
                ans = "NO";
        }
        System.out.print(ans);
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;
        parent[y] = x;
    }

    private static boolean isUnion(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return true;
        return false;
    }
}
