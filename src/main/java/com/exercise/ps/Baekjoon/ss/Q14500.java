package main.java.com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q14500 {

    static int[][] map;
    static boolean[][] visit;
    static int N,M;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        for(int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 맵을 순회하며 4칸 채우면 max값 갱신하는 dfs 돌기
        for(int i = 1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                visit[i][j] = true;
                dfs(i,j, map[i][j], 1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);

    }

    private static void dfs(int y, int x, int sum, int depth) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 1 || ny > N || nx < 1 || nx > M) continue;

            if(!visit[ny][nx]) {

                if(depth == 2) {
                    visit[ny][nx] = true;
                    dfs(y,x, sum + map[ny][nx], depth + 1);
                    visit[ny][nx] = false;
                }

                visit[ny][nx] = true;
                dfs(ny, nx, sum + map[ny][nx], depth + 1);
                visit[ny][nx] = false;
            }
        }

    }
}
