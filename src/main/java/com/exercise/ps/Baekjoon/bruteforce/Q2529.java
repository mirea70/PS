package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2529 {
    private static String min = "9999999999";
    private static String max = "0000000000";
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        char[] signs = new char[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        perm(new boolean[10], signs, new int[k+1], 0, k);
        System.out.println(max);
        System.out.print(min);
    }

    private static void perm(boolean[] visit, char[] signs, int[] current, int depth, int k) {
        if(depth == k+1) {
            for(int num : current) {
                sb.append(num);
            }

            long val = Long.parseLong(sb.toString());
            if(Long.parseLong(min) > val) {
                min = sb.toString();
            }
            if(Long.parseLong(max) < val) {
                max = sb.toString();
            }
            sb.setLength(0);
            return;
        }

        for(int i=0; i<10; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = i;
                if(depth == 0 || validate(signs[depth-1], current[depth-1], current[depth])) {
                    perm(visit, signs, current, depth+1, k);
                }
                visit[i] = false;
            }
        }
    }

    private static boolean validate(char sign, int prev, int val) {
        if(sign == '<') {
            return prev < val;
        }
        else {
            return prev > val;
        }
    }
}
