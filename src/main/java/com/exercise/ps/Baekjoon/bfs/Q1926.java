package com.exercise.ps.Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1926 {
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int n;
    static int m;
    static boolean[][] visit;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];
        for(int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(!visit[r][c] && map[r][c] == 1) {
                    bfs(r, c);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.print(max);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        int count = 1;
        visit[y][x] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            for(int dir=0; dir<4; dir++) {
                int ny = current[0] + dy[dir];
                int nx = current[1] + dx[dir];

                if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if(visit[ny][nx]) continue;
                if(map[ny][nx] == 1) {
                    q.add(new int[]{ny, nx});
                    count++;
                    visit[ny][nx] = true;
                }
            }
        }

        max = Math.max(max, count);
    }
}
