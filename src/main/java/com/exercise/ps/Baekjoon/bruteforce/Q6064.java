package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cx = x;
            int year = x;
            int cy = x % N == 0 ? N : x % N;

            int lcd = (M * N) / getGcd(M, N);

            boolean isFind = false;

            while (year <= lcd) {
                if(cx == x && cy == y) {
                    isFind = true;
                    break;
                }

                year += M;
                cx = (cx + M) % M == 0 ? M : (cx + M) % M;
                cy = (cy + M) % N == 0 ? N : (cy + M) % N;
            }

            System.out.println(isFind ? year : -1);
        }
    }

    private static int getGcd(int a , int b) {
        if(a % b == 0) {
            return b;
        }

        return getGcd(b, a % b);
    }
}
