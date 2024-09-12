package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        System.out.print(factory(n));
    }

    private static long factory(long n) {
        if(n== 0 || n == 1) return 1;

        return n * factory(n-1);
    }
}
