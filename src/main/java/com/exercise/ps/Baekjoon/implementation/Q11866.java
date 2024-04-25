package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++) {
            q.add(i);
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()) {
            int num = q.poll();
            cnt++;
            if(cnt != k) q.add(num);
            else {
                sb.append(num).append(", ");
                cnt = 0;
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append(">");
        System.out.print(sb);
    }
}
