package main.java.com.exercise.ps.Baekjoon.bfs;

import java.io.*;
import java.util.*;

public class Q2206 {

    static int N,M;
    static int min_distance = -1;
    static int[][] origin_map;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 맵 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        origin_map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String[] arr = br.readLine().split("");
            for (int j=1; j<=M; j++) {
                origin_map[i][j] = Integer.parseInt(arr[j-1]);
            }
        }
        // 벽 부수지 않았을때 최단거리 갱신
        bfs(origin_map);
        // origin_map 순회하며 벽 1개 부쉈을때 모든 경우에 대해 bfs 돌고 최단거리 갱신
        for(int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if(origin_map[i][j] == 1) {
                    origin_map[i][j] = 0;
                    bfs(origin_map);
                    origin_map[i][j] = 1;
                }
            }
        }
        // 최단거리 출력
        System.out.println(min_distance);
    }

    private static void bfs(int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,1});

        int[][] copy_map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            copy_map[i] = map[i].clone();
        }

        copy_map[1][1] = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if(copy_map[ny][nx] == 0) {
                    q.add(new int[]{ny,nx});
                    copy_map[ny][nx] = copy_map[now[0]][now[1]] + 1;
                }
            }
        }

       if(copy_map[N][M] != 0) {
           if(min_distance < 0) min_distance = Math.max(min_distance, copy_map[N][M]);
           else min_distance = Math.min(min_distance, copy_map[N][M]);
       }
    }
}
