package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {

    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxHeight = 0;
        int maxCnt = 0;
        // 맵 그리면서 최대 높이 구하기
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                maxHeight = Math.max(maxHeight, val);
            }
        }
        // 2 ~ 최대 높이-1 까지 잠기는 높이 별 안전영역 구하고 갱신
        for(int h = 1; h<=maxHeight; h++) {
             maxCnt = Math.max(maxCnt, getSafeZoneCnt(map, h, N));
        }

        System.out.print(maxCnt == 0 ? 1 : maxCnt);
    }


    private static int getSafeZoneCnt(int[][] map, int limit, int N) {
        int cnt = 0;
        boolean[][] visited = new boolean[N][N];
        // map을 전체 순회하며 limit 큰 dfs 돌아서 끝날때마다 카운트한다.
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                // 방문 아직 안했으면서, limit보다 큰놈만 dfs돈다
                if(!visited[r][c] && map[r][c] > limit) {
                    dfs(map, r, c, visited, limit, N);
                    cnt++;
                }
            }
        }

        return cnt;
    }


    private static void dfs(int[][] map, int y, int x, boolean[][] visited, int limit, int N) {
        // 방문체크
        visited[y][x] = true;
        // 상하좌우 이동시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 경계선 넘을경우 예외
            if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
            // 방문 X이면서 limit보다 크면 dfs
            if(!visited[ny][nx] && map[ny][nx] > limit)
                dfs(map, ny, nx, visited, limit, N);
        }
    }
}
