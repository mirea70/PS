package com.exercise.ps.Baekjoon.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;

        while (x > 0) {
            if ((x & 1) == 1) count++;
            x >>= 1;
        }
        System.out.print(count);
    }
}
