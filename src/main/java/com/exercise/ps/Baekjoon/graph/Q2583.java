package com.exercise.ps.Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2583 {

    private static int[] dy = new int[]{1,-1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int[][] map;
    private static int n;
    private static int m;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        int k = Integer.parseInt(arr[2]);
        map = new int[n+1][m+1];
        List<Integer> list = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j=y1; j<=y2; j++) {
                for(int l=x1; l<=x2; l++) {
                    map[j][l] = 1;
                }
            }
        }

        int total = 0;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(map[i][j] == 0) {
                    cnt = 0;
                    dfs(i,j);
                    list.add(cnt);
                    total++;
                }
            }
        }

        list.sort((o1,o2) -> o1-o2);
        System.out.println(total);
        StringBuilder sb = new StringBuilder();
        for(int a : list) {
            sb.append(a).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb.toString());
    }

    private static void dfs(int y, int x) {
        map[y][x] = 1;
        cnt++;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny > n || ny < 0 || nx > m || nx < 0) continue;
            if(map[ny][nx] == 0) {
                dfs(ny,nx);
            }
        }
    }
}
