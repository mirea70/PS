package main.java.com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1051 {

    static int size = 1;
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ar = br.readLine().split(" ");
        n = Integer.parseInt(ar[0]);
        m = Integer.parseInt(ar[1]);
        // 맵 입력받기
        map = new int[n][m];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            String[] arr = br.readLine().split("");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        // 맵을 순회하며 각 위치 값을 기준으로 정사각형을 탐색한다
        for(int i=0; i<n; i++) {
            for(int j=0; j<m-1; j++) {
                search(0, i, j+1, i, j);
            }
        }
        // 탐색하며 정사각형 크기 최댓값 갱신
        // 최댓값 출력
        System.out.print(size);
        // 방향 : 0: 동, 1: 남, 2: 서, 3: 북
        //
    }

    private static void search(int dir, int y, int x, int toY, int toX) {

        int nDir = dir;
        if(map[y][x] == map[toY][toX]) {
            nDir = (dir + 1) % 4;

            if(nDir == 3) {
                size = Math.max(size, (y-toY + 1) * (y-toY + 1));
                return;
            }
            int[] next = getNext(nDir, y,x);
            int ny = next[0];
            int nx = next[1];
            if(ny < 0 || ny > n-1 || nx < 0 || nx > m-1) return;
            search(nDir, next[0], next[1], toY, toX);
        }
        int[] orgNext = getNext(dir, y, x);
        int ny = orgNext[0];
        int nx = orgNext[1];

        if(ny < 0 || ny > n-1 || nx < 0 || nx > m-1) return;

        search(dir, ny, nx, toY, toX);
    }

    private static int[] getNext(int dir, int y, int x) {
        int ny = y;
        int nx = x;
        switch (dir) {
            case 0: {
                nx = x+1;
            }
            break;
            case 1: {
                ny = y+1;
            }
            break;
            case 2: {
                nx = x-1;
            }
            break;
            case 3: {
                ny = y-1;
            }
            break;
        }
        return new int[]{ny,nx};
    }
}
