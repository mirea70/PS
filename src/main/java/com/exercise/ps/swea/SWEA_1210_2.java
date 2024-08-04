package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1; t<=10; t++) {
            int tc = Integer.parseInt(br.readLine());
            // 지도 입력 -> 그리면서 2 위치 저장
            int[][] map = new int[100][100];
            boolean[][] visited = new boolean[100][100];
            int y = -1;
            int x = -1;
            StringTokenizer st;
            for(int r=0; r<100; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<100; c++) {
                    int val = Integer.parseInt(st.nextToken());
                    if(val == 2) {
                        y = r;
                        x = c;
                    }
                    map[r][c] = val;
                }
            }
            // 2 위치에서 탐색 시작
            // 좌, 우, 상
            int[] dy = {0,0,-1};
            int[] dx = {-1,1,0};
            int startIdx = -1;
            while(true) {
                // 방문 체크
                visited[y][x] = true;
                // 행 위치 == 0이면 그때의 열의 값 출발점으로 저장하고 반복 종료
                if(y == 0) {
                    startIdx = x;
                    break;
                }
                // 좌우상 순으로 이동 시도
                for(int i=0; i<3; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    // 벽이거나, 1이 아니면 pass
                    if(ny < 0 || nx >= 100 || nx < 0 || map[ny][nx] != 1) continue;
                    // 이미 방문했으면 pass
                    if(visited[ny][nx]) continue;
                    // 조건 충족하면 이동, 이동 반복문 종료
                    y = ny;
                    x = nx;
                    break;
                }
            }
            // 출발점 출력
            System.out.printf("#%d %d%n", tc, startIdx);
        }
    }
}
