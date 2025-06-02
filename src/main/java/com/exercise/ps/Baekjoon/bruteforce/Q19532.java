package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int x = getX(a,b,c,d,e,f);
        int y = getY(a,b,c,d,e,f);

        System.out.println(x + " " + y);
    }

    private static int getX(int a, int b, int c, int d, int e, int f) {
        return ((b*f) - (e*c)) / ((b*d) - (a*e));
    }

    private static int getY(int a, int b, int c, int d, int e, int f) {
        return ((a*f) - (d*c)) / ((a*e) - (d*b));
    }
}
