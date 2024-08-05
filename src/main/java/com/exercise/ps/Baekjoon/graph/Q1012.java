package main.java.com.exercise.ps.Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1012 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[] dy = new int[]{1,-1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String[] arr = br.readLine().split(" ");
            m = Integer.parseInt(arr[0]);
            n = Integer.parseInt(arr[1]);
            int k = Integer.parseInt(arr[2]);
            map = new int[n][m];
            for(int j=0; j<k; j++) {
                    String[] s = br.readLine().split(" ");
                    int y = Integer.parseInt(s[1]);
                    int x = Integer.parseInt(s[0]);
                    map[y][x] = 1;
            }
            int cnt = 0;
            for(int j=0; j<n; j++) {
                for(int l=0; l<m; l++) {
                    if(map[j][l] == 1) {
                        dfs(j,l);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void dfs(int y, int x) {
        map[y][x] = 2;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
            if(map[ny][nx]==1) dfs(ny,nx);
        }
    }
}
