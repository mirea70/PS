package main.java.com.exercise.ps.Baekjoon.dfs;

import java.io.*;
import java.util.*;

public class Q9466 {

    static int cnt;
    static int N;
    static int[] arr;
    static boolean[] visit, done;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        // T 반복
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            // 배열의 각 번호에 값을 담는다
            arr = new int[N + 1];
            visit = new boolean[N + 1];
            done = new boolean[N + 1];
            dp = new int[N + 1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            // 배열을 순회
            for (int j = 1; j <= N; j++) {
                if(!done[j])
                    dfs(j);
            }
            // 순회 끝
            // cnt 출력
            System.out.println(N - cnt);
        }
        // T 순회 끝
    }

    private static void dfs(int idx) {
        if(done[idx]) return;
        if(visit[idx]) {
            done[idx] = true;
            cnt++;
        }
        visit[idx] = true;
        dfs(arr[idx]);
        done[idx] = true;
    }
}
