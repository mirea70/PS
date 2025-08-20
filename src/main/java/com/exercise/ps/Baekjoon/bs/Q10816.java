package com.exercise.ps.Baekjoon.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q10816 {
    static Map<Integer, Integer> countMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            int val = Integer.parseInt(st.nextToken());
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] targets = new int[M];
        for(int i=0; i<M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[M];
        for(int i=0; i<M; i++) {
            ans[i] = countMap.getOrDefault(targets[i], 0);
        }

        StringBuilder sb = new StringBuilder();
        for(int count : ans) {
            sb.append(count).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
