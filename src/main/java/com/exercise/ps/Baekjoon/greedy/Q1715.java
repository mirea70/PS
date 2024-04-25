package com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            long num = Long.parseLong(br.readLine());
            q.add(num);
        }
        long cnt = 0;

        while(q.size() > 1) {
            long a = q.poll();
            long b = q.poll();
            cnt+= a+b;
            q.add(a+b);
        }
        System.out.print(cnt);
    }
}
