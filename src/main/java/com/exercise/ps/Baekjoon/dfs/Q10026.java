package main.java.com.exercise.ps.Baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10026 {

    static String[][] map;
    static boolean[][] visit_rgbO;
    static boolean[][] visit_rgbX;

    static int[] dy = new int[]{-1, 1, 0, 0};
    static int[] dx = new int[]{0, 0, -1, 1};

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // 맵을 그린다
        String[] temp = br.readLine().split("");
        M = temp.length;
        map = new String[N][M];
        map[0] = temp;
        for(int i=1; i<N; i++) {
            map[i] = br.readLine().split("");
        }
        // rgbO 방문체크 초기화
        // rgbX 방문체크 초기화
        visit_rgbO = new boolean[N][M];
        visit_rgbX = new boolean[N][M];
        int cnt_rgbO = 0;
        int cnt_rgbX = 0;
        // 맵 순회
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit_rgbO[i][j]) {
                    dfs_rgbO(i, j);
                    cnt_rgbO++;
                }
                if(!visit_rgbX[i][j]) {
                    dfs_rgbX(i, j);
                    cnt_rgbX++;
                }
            }
        }
        // 정답 출력
        System.out.println(cnt_rgbX + " " + cnt_rgbO);
    }

    private static void dfs_rgbO(int y, int x) {
        // 방문 체크
        visit_rgbO[y][x] = true;
        // 상하좌우 이동 시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N) continue;
            if(nx < 0 || nx >= M) continue;
            if(visit_rgbO[ny][nx]) continue;

            String current = map[y][x];
            String next = map[ny][nx];
            // 현재 위치가 R 또는 G일때 -> 다음 위치가 R또는 G이면 dfs
            if(current.equals("R") || current.equals("G")) {
                if(next.equals("R") || next.equals("G")) dfs_rgbO(ny, nx);
            }
            // 아닐 때(B일때) -> 다음 위치가 B이면 dfs
            else {
                if(next.equals("B")) dfs_rgbO(ny, nx);
            }
        }
    }

    private static void dfs_rgbX(int y, int x) {
        // 방문 체크
        visit_rgbX[y][x] = true;
        // 상하좌우 이동 시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N) continue;
            if(nx < 0 || nx >= M) continue;
            if(visit_rgbX[ny][nx]) continue;

            String current = map[y][x];
            String next = map[ny][nx];
            // 현재 위치가 지금 위치의 값과 동일하면 dfs
            if(current.equals(next)) dfs_rgbX(ny, nx);
        }
    }
}
