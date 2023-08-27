package com.exercise.ps.Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_bfs {

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j+1] = str.charAt(j) - '0';
            }
        }
        bfs(1, 1);
        System.out.println(map[N][M]);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visit[y][x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            visit[now[0]][now[1]] = true;
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if (visit[ny][nx] || map[ny][nx] == 0) continue;

                map[ny][nx] = map[now[0]][now[1]] + 1;
                q.offer(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }
}
