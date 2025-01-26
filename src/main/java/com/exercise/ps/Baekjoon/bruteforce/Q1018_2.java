package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018_2 {
    private static int min_cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 보드 그리기
        char[][] board = new char[M][N];
        for(int r=0; r<M; r++) {
            String line = br.readLine();
            for(int c=0; c<N; c++) {
                board[r][c] = line.charAt(c);
            }
        }

        // 보드 자르기
        for(int sRow=0; sRow<=M-8; sRow++) {
            for(int sCol=0; sCol<=N-8; sCol++) {
                min_cnt = Math.min(min_cnt, search(board, sRow, sCol));
            }
        }
        // 최소 갯수 출력
        System.out.print(min_cnt);
    }

    // 탐색
    private static int search(char[][] board, int sRow, int sCol) {
        // 시작이 B
        int count1 = 0;
        // 시작이 W
        int count2 = 0;

        // board 순회
        for(int r=sRow; r<sRow+8; r++) {
            for(int c=sCol; c<sCol+8; c++) {
                int val = board[r][c];
                // r+c가 짝수
                if((r+c) % 2 == 0) {
                    if(val != 'B') count1++;
                    if(val != 'W') count2++;
                }
                // r+c가 홀수
                else {
                    if(val != 'W') count1++;
                    if(val != 'B') count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}
