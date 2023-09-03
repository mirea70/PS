package com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q14889 {

    static int N, min;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        map = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 조합 가능한 모든 조합을 구한다
        combi(new boolean[N], 0, 0, N / 2);
        // 방문마다 차이 최솟값 갱신
        // 차이 최솟값 출력
        System.out.println(min);
    }

    private static void combi(boolean[] visit, int start, int depth, int r) {
        if (depth == r) {
            // map을 통해 각 팀의 능력치를 구한다
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i+1; j < N; j++) {
                    if (visit[i] && visit[j]) sum1 += map[i + 1][j + 1] + map[j + 1][i + 1];
                    else if (!visit[i] && !visit[j]) sum2 += map[i + 1][j + 1] + map[j + 1][i + 1];
                }
            }
            // 차이값의 최솟값 갱신
            int val = Math.abs(sum1 - sum2);
            if(val == 0) {
                System.out.println(val);
                System.exit(0);
            }
            min = Math.min(min, Math.abs(sum1 - sum2));
            return;
        }


        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combi(visit, i + 1, depth + 1, N / 2);
                visit[i] = false;
            }
        }
    }
}
