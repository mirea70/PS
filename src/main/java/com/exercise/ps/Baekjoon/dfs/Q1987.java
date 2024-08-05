package main.java.com.exercise.ps.Baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q1987 {

    static int R;
    static int C;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] map;
    static int max = 0;
    static boolean[] alpha = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // map을 그린다
        map = new int[R][C];
        for(int i=0; i<R; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(s -> s.charAt(0) - 'A').toArray();
        }
        // 저장 리스트 초기화
        // 0,0부터 dfs 시작
        dfs(0,0, 1);
        // 갱신된 최댓값 출력
        System.out.println(max);
    }

    private static void dfs(int y, int x, int len) {
        // 현재 칸을 리스트에 담는다
        alpha[map[y][x]] = true;
        // 상하좌우 이동 시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 벽 예외처리
            if(ny < 0 || ny >= R) continue;
            if(nx < 0 || nx >= C) continue;
            // 다음 칸 값이 리스트에 없는 값이면 이동
            if(!alpha[map[ny][nx]]) {
                dfs(ny,nx, len + 1);
                alpha[map[ny][nx]] = false;
            }
            // 이동시도 끝
        }
        // max 값 갱신
        max = Math.max(max, len);
    }
}
