package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2564 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[] min_lengths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];

        int store_len = Integer.parseInt(br.readLine());
        // 상점 별 최단거리 배열
        min_lengths = new int[store_len+1];
        Arrays.fill(min_lengths, Integer.MAX_VALUE);
        // 입력을 받으면서 지도에 상점의 위치를 저장.
        // 동근이 위치도 같이
        int y = -1;
        int x = -1;
        for(int i=1; i<=store_len+1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            int sy;
            int sx;

            switch (p) {
                case 1: {
                    sy = 0;
                    sx = distance;
                }
                break;
                case 2: {
                    sy = n;
                    sx = distance;
                }
                break;
                case 3: {
                    sy = distance;
                    sx = 0;
                }
                break;
                default: {
                    sy = distance;
                    sx = m;
                }
            }
            if(i ==store_len+1) {
                y = sy;
                x = sx;
            }
            else map[sy][sx] = i;
        }
        // 동근이 시계방향 한바퀴 이동
        move(y, x, true);
        // 동근이 반시계방향 한바퀴 이동
        move(y, x, false);

//        System.out.println(Arrays.toString(min_lengths));
        // 상점 별 최단 거리 배열의 합 출력
        int sum = 0;
        for(int i=1; i<min_lengths.length; i++) {
                sum += min_lengths[i];
        }

        System.out.print(sum);
    }

    // 방향에 따라 동근이를 한바퀴 돌리고 상점별 최단거리를 갱신하는 함수
    private static void move(int y, int x, boolean isClock) {
        // 꺾는 방향 설정
        int[] dy;
        int[] dx;
        // 초기 동근이 방향 설정
        int dir = -1;
        // 시계 방향일 경우
        if(isClock){
            // 좌상우하
            dy = new int[]{0,-1,0,1};
            dx = new int[]{-1,0,1,0};
            if(y == 0) {
                dir = 2;
            } else if (y == n) {
                dir = 0;
            } else if (x == 0) {
                dir = 1;
            }
            else if (x == m) {
                dir = 3;
            }
        }
        // 반시계 방향일 경우
        else {
            // 우상좌하
            dy = new int[]{0,-1,0,1};
            dx = new int[]{1,0,-1,0};
            if(y == 0) {
                dir = 2;
            } else if (y == n) {
                dir = 0;
            } else if (x == 0) {
                dir = 3;
            }
            else if (x == m) {
                dir = 1;
            }
        }
        // 움직인 좌표가 다시 y, x일 때까지 반복
        int count = 0;
        int ty = -1;
        int tx = -1;
//        System.out.println(isClock ? "시계" + "방향 시작" : "반시계" + "방향 시작");
        while(!(y == ty && x == tx)) {
            // 동근이 위치 초기화(처음에만)
            if(ty == -1 && tx == -1) {
                ty = y;
                tx = x;
            }
            // 현재 위치의 값이 상점의 번호일 경우 해당 상점의 거리 최소값 갱신
            int index = map[y][x];
            if(index != 0) {
//                System.out.println("y : " + y);
//                System.out.println("x : " + x);
                min_lengths[index] = Math.min(min_lengths[index], count);
            }
            // - 카운트
            count++;
            // 이동 시도
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            // - 다음 갈 곳이 벽이면 방향 꺾기
            if(ny > n || ny < 0 || nx > m || nx < 0) {
                dir = (dir+1) %4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            // 이동
            y = ny;
            x = nx;
        }
        // 반복 끝
    }
}
