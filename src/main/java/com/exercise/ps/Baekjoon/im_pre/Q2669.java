package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 평면 준비
        int[][] board = new int[101][101];
        // 도형을 입력받으며 해당하는 좌표는 1로 변경
        StringTokenizer st;
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int r=y1; r<y2; r++) {
                for(int c=x1; c<x2; c++) {
                    board[r][c] = 1;
                }
            }
        }
        // 입력 끝
        int count = 0;
        // 평면 순회
        for(int r=0; r<101; r++) {
            for(int c=0; c<101; c++) {
                // 1이면 카운트
                if(board[r][c] == 1)
                    count++;
            }
        }
        // 순회 끝
        // 카운트 출력
        System.out.print(count);
    }
}
