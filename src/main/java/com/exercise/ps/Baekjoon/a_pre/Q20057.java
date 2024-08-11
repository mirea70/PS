package main.java.com.exercise.ps.Baekjoon.a_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q20057 {

    private static int out_sum = 0;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 지도 입력
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 지도 중앙으로 토네이도 위치 초기화
        int y = n / 2;
        int x = n / 2;
        // 좌하우상
        int[] dy = {0, 1, 0, -1};
        int[] dx = {-1, 0, 1, 0};

        int dir = 0;
        // 이동거리의 길이
        int len = 1;
        // 이동 카운트
        int move_cnt = 0;
        // 토네이도 이동
        out: while (y > 0 || x > 0) {
            // 이동카운트가 2라면 이동거리 길이를 늘린다.
            if(move_cnt == 2) {
                move_cnt = 0;
                len++;
            }
            // 이동 카운트 누적
            move_cnt++;
            // 이동거리 길이만큼 이동한다
            for(int i=0; i<len; i++) {
                // - 이동하면서 모래 흩날리기
                y = y + dy[dir];
                x = x + dx[dir];
                wind(map, dir, y, x);
                if(y == 0 && x == 0) {
                    break out;
                }
            }
            // 꺾기
            dir = (dir+1) % 4;
        }
        // 이동 끝
        // 바깥 모래양 출력
        System.out.print(out_sum);
    }

    private static void wind(int[][] map, int dir, int y, int x) {
        int val = map[y][x];
        int[][] moves = new int[10][3];
        int[] percents = {1, 1, 2, 7, 7, 2, 10, 10, 5, 0};
        int[] dy, dx;

        switch (dir) {
            case 0: // 왼쪽
                dy = new int[]{-1, 1, -2, -1, 1, 2, -1, 1, 0, 0};
                dx = new int[]{1, 1, 0, 0, 0, 0, -1, -1, -2, -1};
                break;
            case 1: // 아래
                dy = new int[]{-1, -1, 0, 0, 0, 0, 1, 1, 2, 1};
                dx = new int[]{-1, 1, -2, -1, 1, 2, -1, 1, 0, 0};
                break;
            case 2: // 오른쪽
                dy = new int[]{-1, 1, -2, -1, 1, 2, -1, 1, 0, 0};
                dx = new int[]{-1, -1, 0, 0, 0, 0, 1, 1, 2, 1};
                break;
            default: // 위
                dy = new int[]{1, 1, 0, 0, 0, 0, -1, -1, -2, -1};
                dx = new int[]{-1, 1, -2, -1, 1, 2, -1, 1, 0, 0};
                break;
        }

        int movedSand = 0;
        for (int i = 0; i < 9; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            int sand = (val * percents[i]) / 100;
            movedSand += sand;

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                out_sum += sand;
            } else {
                map[ny][nx] += sand;
            }
        }

        // 'a' 위치 처리
        int ny = y + dy[9];
        int nx = x + dx[9];
        int remainingSand = val - movedSand;
        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
            out_sum += remainingSand;
        } else {
            map[ny][nx] += remainingSand;
        }

        map[y][x] = 0;
    }
}
