package com.exercise.ps.Baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Q7569 {

    static int M,N,H;
    static int[][][] map;
    static boolean[][][] visit;
    static Queue<int[]> q = new LinkedList<>();

    // 위, 아래, 상, 하, 좌, 우
    static int[] dh = new int[]{1, -1, 0,0,0,0};
    static int[] dy = new int[]{0,0,-1,1,0,0};
    static int[] dx = new int[]{0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 맵 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M =  Integer.parseInt(st.nextToken());
        N =  Integer.parseInt(st.nextToken());
        H =  Integer.parseInt(st.nextToken());
        map = new int[H+1][N+1][M+1];
        visit = new boolean[H+1][N+1][M+1];
        for(int h=1; h<=H; h++) {
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    map[h][i][j] = value;
                    // 입력하며 값이 1이면 큐에 미리담기
                    if(value == 1) {
                        q.add(new int[]{h, i, j});
                        visit[h][i][j] = true;
                    }
                }
            }
        }
        // bfs 돈 값을 출력
        System.out.println(bfs());
    }

    private static int bfs() {
        // dfs 탐색
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<6; i++) {
                int nh = now[0] + dh[i];
                int ny = now[1] + dy[i];
                int nx = now[2] + dx[i];

                if(nh < 1 || nh > H || ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if(visit[nh][ny][nx]) continue;
                if(map[nh][ny][nx] == 0) {
                    visit[nh][ny][nx] = true;
                    map[nh][ny][nx] = map[now[0]][now[1]][now[2]] + 1;
                    q.add(new int[]{nh,ny,nx});
                }
            }
        }

        if(hasZero()) return -1;

        int max = 1;
        for(int h=1; h<=H; h++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    if(map[h][i][j] > max) max = Math.max(max, map[h][i][j]);
                }
            }
        }
        return max -1;
    }

    private static boolean hasZero() {
        for(int h=1; h<=H; h++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    if(map[h][i][j] == 0) return true;
                }
            }
        }
        return false;
    }
}
