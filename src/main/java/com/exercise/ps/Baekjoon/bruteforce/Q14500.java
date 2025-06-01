package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    private static int max = 0;
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int N;
    private static int M;
    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                visit[r][c] = true;
                dfs(r, c, map[r][c], 1);
                visit[r][c] = false;
            }
        }
        System.out.print(max);
    }

    // 기준점에서 상하좌우 탐색을 카운트 4까지 시도하면 테트로미노 4번까지 탐색이 가능
    // 5번은 카운트 2일때 다음꺼 방문했다 치고, 다시 현위치에서 탐색하면 완성 가능
    private static void dfs(int r, int c, int sum, int count) {
        // 카운트 4이면 max 갱신
        if(count == 4) {
            max = Math.max(max, sum);
            return;
        }
        // 상하좌우 탐색
        for(int i=0; i<4; i++) {
            int nr = r + dy[i];
            int nc = c + dx[i];
            // 경계 넘으면 패스
            if(nr >= N || nr < 0 || nc >= M || nc < 0)
                continue;

            // 이미 방문했으면 패스
            if(visit[nr][nc]) continue;
            // 카운트 2이면 같은 자리에서 한번 더 탐색
            if(count == 2) {
                visit[nr][nc] = true;
                dfs(r, c, sum + map[nr][nc], count+1);
                visit[nr][nc] = false;
            }

            visit[nr][nc] = true;
            dfs(nr, nc, sum + map[nr][nc], count+1);
            visit[nr][nc] = false;
        }
    }
}
