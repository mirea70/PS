package main.java.com.exercise.ps.Baekjoon.ss;

import java.io.*;
import java.util.*;
import java.lang.ref.Cleaner;

public class Q14503 {

    static int[][] map;
    static int N, M;
    // 북동남서
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        Cleaner cleaner = new Cleaner(y, x, dir);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 청소기를 dfs 돌린다
        dfs(cleaner);
        // 청소한 횟수를 출력한다
        System.out.print(cnt);
    }

    private static void dfs(Cleaner cleaner) {

        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if (map[cleaner.y][cleaner.x] == 0) cleaner.clean(map);
        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
        if (chk360(cleaner.y, cleaner.x)) {
            // 반시계 방향으로 90도 회전한다.
            cleaner.rotate90();
            // 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            int ny = cleaner.y + dy[cleaner.dir];
            int nx = cleaner.x + dx[cleaner.dir];
            if (map[ny][nx] == 0) cleaner.ahead();
            // 1번으로 돌아간다.
			dfs(cleaner);
        } else {
            int ny = cleaner.y - dy[cleaner.dir];
            int nx = cleaner.x - dx[cleaner.dir];
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            // 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] == 1) return;
                // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            else {
                cleaner.back();
				dfs(cleaner);
            }

        }
    }

    private static boolean chk360(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (map[ny][nx] == 0) return true;
        }
        return false;
    }

    public static class Cleaner {
        int y;
        int x;
        int dir;

        // 90도 회전
        private void rotate90() {
            this.dir = this.dir == 0 ? 3 : this.dir - 1;
        }

        private void clean(int[][] map) {
            map[y][x] = 2;
            cnt++;
        }

        public Cleaner(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }

        private void ahead() {
            int ny = this.y + dy[this.dir];
            int nx = this.x + dx[this.dir];

            this.y = ny;
            this.x = nx;
        }

        private void back() {
            int ny = this.y - dy[this.dir];
            int nx = this.x - dx[this.dir];

            this.y = ny;
            this.x = nx;
        }
    }
}
