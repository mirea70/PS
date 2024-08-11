package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도화지 공간 생성
        int[][] board = new int[100][100];
        // 색종이를 입력받으면서 해당 영역을 모두 1로 변환
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int r=y; r<y+10; r++) {
                for(int c=x; c<x+10; c++) {
                    board[r][c] = 1;
                }
            }
        }
        // 입력 받기 끝
        // 도화지 순회 -> 1인 공간 카운팅
        int count = 0;
        for(int r=0; r<100; r++) {
            for(int c=0; c<100; c++) {
                if(board[r][c] == 1)
                    count++;
            }
        }
        // 카운팅 숫자 출력
        System.out.print(count);
    }
}
