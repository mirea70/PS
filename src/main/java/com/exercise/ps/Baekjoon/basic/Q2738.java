package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        int[][] C = new int[N][M];

        // A 구하기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // B 구하기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // A+B 구하기
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(C[i][j]).append(" ");
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
