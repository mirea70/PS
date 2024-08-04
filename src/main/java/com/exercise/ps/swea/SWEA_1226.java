package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1226 {

    private static char[][] map;
    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};
    private static boolean[][] visited;
    private static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1; t<=10; t++) {
            br.readLine();

            int y = -1;
            int x = -1;
            map = new char[16][16];
            visited = new boolean[16][16];
            // map 그리면서 출발점 찾기
            for(int i=0; i<16; i++) {
                map[i] = br.readLine().toCharArray();
                for(int j=0; j<16; j++) {
                    if(map[i][j] == '2') {
                        y = i;
                        x = j;
                    }
                }
            }
            // dfs를 돈다
            dfs(y,x);
            // 3을 한번이라도 만났으면 true 아니면 false
            System.out.printf("#%d %d%n", t, isPossible ? 1 : 0);
            isPossible = false;
        }
    }

    private static void dfs(int y, int x) {
        if(isPossible) return;
        // 방문 체크
        visited[y][x] = true;
        if(map[y][x] == '3') {
            isPossible = true;
            return;
        }
        // 상하좌우 이동 시도
        for(int i=0; i<4; i++) {
            int ny = y +dy[i];
            int nx = x + dx[i];
            // 벽이면 pass
            if(ny >= 16 || ny < 0 || nx >= 16 || nx < 0) continue;
            // 방문했으면 pass
            if(visited[ny][nx]) continue;
            // 0 또는 3이 아니면 pass
            if(map[ny][nx] != '0' && map[ny][nx] != '3') continue;
            // 검수 통과하면 dfs
            dfs(ny, nx);
//            visited[ny][nx] = false;
        }
    }
}
