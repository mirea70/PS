package com.exercise.ps.Baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Q1012 {

    // 상하좌우
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // T 개수만큼 반복
        for(int i=0; i<T; i++) {
            // Map을 그린다
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int bae = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];
            for(int j=0; j<bae; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int cnt = 0;
            // Map을 0,0부터 순회한다
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    // 방문하지 않았을 경우에만 순회
                    if(!visit[j][k]) {
                        // 방문체크
                        visit[j][k] = true;
                        // 1을 찾으면 dfs 돌기, cnt++
                        if(map[j][k] == 1) {
                            cnt++;
                            dfs(j,k, visit, map);
                        }
                    }
                }
            }
            // map 순회 끝
            // cnt 출력
            System.out.println(cnt);
            // T 반복 종료
        }
    }

    private static void dfs(int y, int x, boolean[][] visit, int[][] map) {
        // 방문 체크
        visit[y][x] = true;
        // 상하좌우 이동 시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N) continue;
            if(nx < 0 || nx >= M) continue;

            if(map[ny][nx] == 1 && !visit[ny][nx])
                dfs(ny, nx, visit, map);
        }
    }
}
