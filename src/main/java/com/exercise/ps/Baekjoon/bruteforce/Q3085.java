package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3085 {
    private static char[][] board;
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int eat_max = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int r=0; r<N; r++) {
            board[r] = br.readLine().toCharArray();
        }

        // eat_max 최초 업데이트
        updateEatMax();
        // 보드 순회
        for(int r=0 ;r<N; r++) {
            for(int c=0; c<N; c++) {
                // 교환 시도
                exchange(r, c);
            }
        }
        // 순회 끝
        // 사탕 최대값 출력
        System.out.print(eat_max);
    }

    private static void exchange(int y, int x) {
        // 상하좌우 교환시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
            if(board[ny][nx] != board[y][x]) {
                // 교환
                char temp = board[y][x];
                board[y][x] = board[ny][nx];
                board[ny][nx] = temp;
                // y, x 기준 선택해서 최대값 업데이트
                updateEatMax(y, x);
                // ny, nx 기준 선택해서 최대값 업데이트
                updateEatMax(ny, nx);
                // 되돌리기
                board[ny][nx] = board[y][x];
                board[y][x] = temp;
            }
        }
    }

    // 전체 최초 업데이트
    private static void updateEatMax() {
        int max = 0;
        // board 순회
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                // 행 방향 체크 (우측만 세도됨)
                int r_count = 1;
                r_count += getCount(r, c, 3);
                // 열 방향 체크 (아래만 세도됨)
                int c_count = 1;
                c_count += getCount(r, c, 1);

                max = Math.max(max, Math.max(r_count, c_count));
            }
        }
        // 순회 끝
        // eat_max 업데이트
        eat_max = Math.max(eat_max, max);
    }

    // 주어진 y, x 기준으로 업데이트
    private static void updateEatMax(int y, int x) {
        // 좌우 방향
        int r_count = 1;
        r_count += getCount(y, x, 2);
        r_count += getCount(y, x, 3);

        // 상하 방향
        int c_count = 1;
        c_count += getCount(y, x, 0);
        c_count += getCount(y, x, 1);

        eat_max = Math.max(eat_max, Math.max(r_count, c_count));
    }

    private static int getCount(int y, int x, int dir) {
        int count = 0;
        int ny = y;
        int nx = x;
        while (true) {
            ny += dy[dir];
            nx += dx[dir];
            if(ny >= N || ny < 0 || nx >= N || nx < 0) break;
            if(board[ny][nx] != board[y][x]) break;
            count++;
        }

        return count;
    }
}
