package main.java.com.exercise.ps.Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {

    static int N, M;
    static int[][] map;
    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    q.offer(new int[]{i,j});
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {

        int max = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i = 0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 1 || ny > N || nx < 1 || nx > M) continue;
                if(map[ny][nx] != 0) continue;
                q.offer(new int[]{ny, nx});
                map[ny][nx] = map[now[0]][now[1]] + 1;
                max = Math.max(max, map[ny][nx]);
            }
        }

        if(checkZero()) return -1;

        return max - 1;

    }

    private static boolean checkZero() {
        for(int i = 1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                if(map[i][j] == 0) return true;
            }
        }
        return false;
    }
}
