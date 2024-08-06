package main.java.com.exercise.ps.Baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Q14502 {

    static int N,M;
    static int max = Integer.MIN_VALUE;
    static int[][] origin_map;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        origin_map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                origin_map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int depth) {
        // 벽 3개 세우는 모든 경우의 수 방문
        // 벽이 3개 세워질 때마다 bfs로 바이러스 퍼뜨리고 안전지역 최댓값 갱신
        if(depth == 3) {
            bfs();
            return;
        }
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(origin_map[i][j] == 0) {
                    origin_map[i][j] = 1;
                    dfs(depth + 1);
                    origin_map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(origin_map[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] copy_map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            copy_map[i] = origin_map[i].clone();
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if(copy_map[ny][nx] == 0) {
                    q.add(new int[]{ny,nx});
                    copy_map[ny][nx] = 2;
                }
            }
        }
        // 안전지역 세고, max 최신화
        countSafeZone(copy_map);
    }

    private static void countSafeZone(int[][] copy_map) {
        int safeZone = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(copy_map[i][j] == 0) safeZone++;
            }
        }
        max = Math.max(max, safeZone);
    }
}
