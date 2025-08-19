package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR23803 {
    // 아래 오른
    static int[] dy = new int[]{1, 0};
    static int[] dx = new int[]{0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        int len = N*5;
        // N * 5 가로 세로크기로 저장공간 만들기
        char[][] map = new char[len][len];
        // ㄴ자 모양으로 N번 쌓기
        for(int order=0; order<N; order++) {
            fill(map, order);
        }

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<len; r++) {
            for(int c=0; c<len; c++) {
                if(map[r][c] != '\u0000') {
                    sb.append(map[r][c]);
                }
            }
            sb.append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    // ㄴ자 그리기 함수
    private static void fill(char[][] map, int order) {
        int len = map.length;
        int y = 0;
        int x = order;
        int dir = 0;
    // 현재 번호 열부터 시작해서 경계 or @에 닿을 때까지 채우고
    // 우측으로 방향전환 -> 경계까지 채우기
        while (true) {
            map[y][x] = '@';
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if(ny >= len || ny < 0 || nx >= len || nx < 0 || map[ny][nx] == '@') {
                if(dir == 1) {
                    break;
                }
                else {
                    dir++;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }
            }

            y = ny;
            x = nx;
        }
    }
}
