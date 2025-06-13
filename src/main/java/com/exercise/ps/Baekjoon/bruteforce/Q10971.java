package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10971 {
    private static int[][] price_matrix;
    private static int N;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        price_matrix = new int[N+1][N+1];
        for(int r=1; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++) {
                price_matrix[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        perm(1, new boolean[N+1], 0, 0, 1);
        System.out.print(min);
    }

    private static void perm(int si, boolean[] visit, int depth, int price, int fi) {

//        System.out.println("depth : " + depth + ", price : " + price);
//        System.out.println("si = " + si);

        if(depth == N) {
//            System.out.println("price = " + price);
//            System.out.println("visit = " + Arrays.toString(visit));
            if(price_matrix[si][fi] != 0)
                min = Math.min(min, price + price_matrix[si][fi]);
//            min = Math.min(min, price);
            return;
        }

        for(int i=1; i<=N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                if(depth == 0) {
                    perm(i, visit, depth+1, price, i);
                }

                if(price_matrix[si][i] != 0) {
                    perm(i, visit, depth+1, price + price_matrix[si][i], fi);
                }
                visit[i] = false;
            }
        }
    }
}
