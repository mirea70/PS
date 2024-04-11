package com.exercise.ps.Baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2644 {

    private static int[][] map;
    private static int n;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        // map에 일촌 채우기
        map = new int[n+1][n+1];
        visit = new boolean[n+1];
        int num = Integer.parseInt(br.readLine());
        for(int i=1; i<=num; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            map[x][y] = 1;
        }
        // 주어진 2번째 수의 열부터 dfs
        int output = dfs(input, 0, target);
        System.out.print(output);
    }

    private static int dfs(int current, int depth, int target) {
        // 타겟을 찾았으면 그때 depth = 촌수 : 촌수 리턴
        visit[current] = true;
        if(current == target) return depth;
        // 1~ n까지 순회하여 0이 아니면 dfs
        for(int i=1; i<=n; i++) {
            if(map[current][i] != 0 && !visit[i]) {
                int result = dfs(i, depth + 1, target);
                if(result != -1) return result;
            }
        }
        // 순회를 끝냈는데도 갈곳이없으면 -1 리턴
        return -1;
    }
}
