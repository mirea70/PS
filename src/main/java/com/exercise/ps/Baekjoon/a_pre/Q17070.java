package com.exercise.ps.Baekjoon.a_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {

    private static int[][] map;
    static int n;
    private static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        // 집 지도 입력
        map = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // dfs 시작
        dfs(0, 1, 0);
        // 방법의 수 출력
        System.out.print(count);
    }

    private static void dfs(int y, int x, int dir) {
        if (y == n - 1 && x == n - 1) {
            count++;
            return;
        }

        // 가로이동 : 가로, 대각선일때만 가능
        if (dir == 0 || dir == 2) {
            if (x + 1 < n && map[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
        }
        // 세로 : 세로, 대각선일때만 가능
        if (dir == 1 || dir == 2) {
            if (y + 1 < n && map[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
        }
        // 대각선 : 언제나 가능
        if (x + 1 < n && y + 1 < n && map[y + 1][x + 1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0) {
            dfs(y + 1, x + 1, 2);
        }
    }
}