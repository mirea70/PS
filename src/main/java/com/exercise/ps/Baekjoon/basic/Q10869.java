package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(add(a,b));
        System.out.println(minus(a,b));
        System.out.println(multiple(a,b));
        System.out.println(divide(a,b));
        System.out.println(remain(a,b));
    }

    private static int add(int a, int b) {
        return a+b;
    }

    private static int minus(int a, int b) {
        return a-b;
    }

    private static int multiple(int a, int b) {
        return a*b;
    }

    private static int divide(int a, int b) {
        return a/b;
    }

    private static int remain(int a, int b) {
        return a%b;
    }
}
