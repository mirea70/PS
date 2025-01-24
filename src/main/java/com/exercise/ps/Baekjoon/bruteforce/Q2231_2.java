package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i=1; i<N; i++) {
            int res = getDecomposableSum(i);
            if(res == N) {
                ans = i;
                break;
            }
        }

        System.out.print(ans);
    }

    private static int getDecomposableSum(int num) {
        String num_str = String.valueOf(num);
        int sum = 0;
        for(char c : num_str.toCharArray())
            sum += c-'0';
        return num + sum;
    }
}
