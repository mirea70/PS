package main.java.com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 빙고판 그리기
        int[][] board = new int[5][5];
        for(int r=0; r<5; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<5; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 사회자가 불러주는대로 빙고판을 -1로 채워나가기
        int count  = 0;
        out: for(int r=0; r<5; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<5; c++) {
                count++;
                // -1 채우기
                fill(board, Integer.parseInt(st.nextToken()));
                // - 채워나가면서 15번째 이상일때부터 그어진 선 체크
                int res = check(board);
                // 그어진 선이 3이상이라면 그때의 번호 저장하고 반복 종료
                if(res >= 3) break out;
            }
        }
        // 저장된 번호 출력
        System.out.print(count);
    }

    private static void fill(int[][] board, int target) {
        for(int r=0; r<5; r++) {
            for(int c=0; c<5; c++) {
                 if(board[r][c] == target) {
                     board[r][c] = -1;
                     return;
                 }
            }
        }
    }

    private static int check(int[][] board) {
        int count = 0;
        int leftTomDia_cnt = 0;
        int leftBotDia_cnt = 0;
        for(int i=0; i<5; i++) {
            // i행의 -1 누적개수 체크
            int row_cnt = 0;
            // i열의 -1 누적개수 체크
            int col_cnt = 0;
            for(int j=0; j<5; j++) {
                if(board[i][j] == -1) row_cnt++;
                if(board[j][i] == -1) col_cnt++;
            }
            // 왼위 -> 오른아래 대각 누적
            if(board[i][i] == -1) leftTomDia_cnt++;
            // 왼아래 -> 오른위 대각 누적
            if(board[4-i][i] == -1) leftBotDia_cnt++;
            // i행 -1 누적개수 5이면 count++
            if(row_cnt == 5) count++;
            // i열 -1 누적개수 5이면 count++
            if(col_cnt == 5) count++;
        }
        if(leftTomDia_cnt == 5) count++;
        if(leftBotDia_cnt == 5) count++;

        return count;
    }
}
