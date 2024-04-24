package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                queue.add(x);
            }
            else {
                int res = !queue.isEmpty() ? queue.poll() : 0;
                System.out.println(res);
            }
        }
    }
}
