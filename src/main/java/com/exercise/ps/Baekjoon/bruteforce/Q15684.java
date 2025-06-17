package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15684 {
    private static boolean[][] board;
    private static int N;
    private static int M;
    private static int H;
    private static int min_count = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 맵 그리기
        board = new boolean[H+1][N+1];
        if(M > 0) {
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[a][b] = true;
            }
        }
        // 각 세로선 별로 행단위로 순회하며 가로선을 놓기/안놓기 결정한다.
        dfs(0,1, 1);
        // 가로선 개수 최솟값 출력
        System.out.print(min_count > 3 ? -1 : min_count);
    }

    private static void dfs(int added, int startH, int startN) {
        if(added >= min_count) return;

        if(check()) {
            min_count = added;
            return;
        }

        if(added >= 3) return;

        for(int h= startH; h<=H; h++) {
            for(int n= (h == startH ? startN : 1); n<N; n++) {
                if (board[h][n] || board[h][n-1] || board[h][n+1]) continue;

                board[h][n] = true;
                dfs(added+1, h, n);
                board[h][n] = false;
            }
        }
    }

    private static boolean check() {
        // 각 세로선을 순회
        for(int i=1; i<=N; i++) {
            int h = 1;
            int x = i;
            while(h <= H) {
                // 주어진 board에 따라 현재 index 위치 변경
                if(x > 1 && board[h][x-1]) {
                    x -= 1;
                }
                else if(x < N && board[h][x]) {
                    x += 1;
                }
                h++;
            }
            // 최종 높이까지 도달
            // 최종 높이에서 세로선과 인덱스가 같지 않으면 그냥 종료
            if(i != x) return false;
        }
        // 순회 끝
        return true;
    }

    private static int count() {
        int count = 0;
        for(int c=1; c<N; c++) {
            for(int r=1; r<=H; r++) {
                if(board[r][c]) count++;
            }
        }
        return count;
    }
}
