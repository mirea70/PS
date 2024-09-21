package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Integer.parseInt(br.readLine());

        String b = br.readLine();
        long b1 = b.charAt(2) - '0';
        long b2 = b.charAt(1) - '0';
        long b3 = b.charAt(0) - '0';

        long r3 = a*b1;
        long r4 = a*b2 * 10;
        long r5 = a*b3 * 100;
        long r6 = r3+r4+r5;

        System.out.println(r3);
        System.out.println(r4/10);
        System.out.println(r5/100);
        System.out.println(r6);
    }
}
