package com.exercise.ps.softeer;

import java.io.*;
import java.util.*;

public class Obstacle {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dy = new int[]{1,-1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int n;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 지도 그리기
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            map[i] = arr;
        }
        // 지도 순회
        List<Integer> list = new ArrayList<>();
        // int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 1이면 dfs -> 개수 카운트
                if(!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    // 탐색 끝날 때마다 해당 카운트 추가
                    list.add(cnt);
                    cnt = 0;
                }
            }
        }
        // 순회 끝
        // 리스트 오름차순 정렬
        Collections.sort(list);
        // 리스트 사이즈, 요소 출력
        System.out.println(list.size());
        for(int a : list) System.out.println(a);
    }

    private static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;
        // 상하좌우 시도
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            // 경계 넘으면 패스
            if(ny >= n || ny <0 || nx >= n || nx <0) continue;
            // 방문하지 않았고, 1이면 dfs
            if(!visited[ny][nx] && map[ny][nx] == 1)
                dfs(ny, nx);
        }
    }
}
