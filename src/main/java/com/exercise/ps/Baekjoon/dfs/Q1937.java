package com.exercise.ps.Baekjoon.dfs;

import java.util.*;
import java.io.*;

public class Q1937 {

    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // 맵 그린다
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        int max = 0;
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 맵 순회
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                // dfs를 돌며, 각 점을 시작점으로 했을때 최댓값을 갱신한다
                max = Math.max(max, dfs(i,j));
            }
        }
        // 최댓값 출력
        System.out.println(max);
    }

    private static int dfs(int y, int x) {
        if(dp[y][x] != 0) return dp[y][x];
        dp[y][x] = 1;
        // 상하좌우 이동시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 벽 예외
            if(ny < 1 || ny > N || nx < 1 || nx > N) continue;
            // 다음 칸 > 현재 칸이면 dfs -> 현재 칸 값에 해당 값 최신화
            if(map[ny][nx] > map[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx)+1);
            }
        }
        // 상하좌우 끝
        // 현재 dp값을 출력하기
        return dp[y][x];
    }
}
