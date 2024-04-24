package com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11047_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i=0; i<n; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        while(!stack.isEmpty()) {
            int num = stack.pop();
            if(k <= 0) break;
            if(k % num == 0) {
                cnt += k / num;
                break;
            }
            else {
                if(num <= k) {
                    cnt += k / num;
                    k = k % num;
                }
            }
        }
        System.out.print(cnt);
    }
}
