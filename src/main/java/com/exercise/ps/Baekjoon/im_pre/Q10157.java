package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        // r*c 2차원 배열 공간 만들기
        int[][] map = new int[n][m];
        int len = m*n;
        // k > len이라면 찾을 수 없으므로 0출력 후 시스템 종료
        if(k > len) {
            System.out.print("0");
            System.exit(0);
        }
        int y = 0;
        int x = 0;
        // 0,0부터 상우하좌 순으로 돌아가며 map 채우기
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int now = 1;
        int dir = 0;
        while(now <= len) {
            map[y][x] = now;
            // - 만약 타겟을 찾았다면, 반복 종료하고 현재 위치 저장
            if(now == k) {
                break;
            }
//            System.out.println("y, x = " + y + ", " + x);

            int ny = y + dy[dir];
            int nx = x + dx[dir];
            // 꺾기 조건
            // 1. 벽 만났을때
            // 2. 0이 아닌 수를 만났을 때 (이미 방문)
            if(ny >= n || ny < 0 || nx >= m || nx < 0 || map[ny][nx] != 0) {
                dir = (dir+1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            // 이동
            y = ny;
            x = nx;
            now++;
        }
        // 타겟 위치 출력
        System.out.print((x + 1) + " " + (y + 1));
    }
}
