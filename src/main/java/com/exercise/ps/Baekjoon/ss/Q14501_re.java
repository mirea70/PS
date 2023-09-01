package com.exercise.ps.Baekjoon.ss;

import java.io.*;
import java.util.*;

public class Q14501_re {

    static int N,max;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = 0;

        list.add(new int[0]);
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new int[]{t,p});
        }
        // N까지 순회하며 해당 날짜를 첫 일로하는 dfs를 돈다
        for(int i=1; i<=N; i++) {
            dfs(i, 0);
        }
        // 최대 수익 출력
        System.out.println(max);
    }

    private static void dfs(int time, int sum) {
        int[] now = list.get(time);
        // 현재 날짜 + 이동할 날짜가 N보다 크면
        if(time + now[0] > N) {
            sum = time + now[0] == N+1 ? sum + now[1] : sum;
            // 최대 수익 갱신하고 탈출
           max = Math.max(max, sum);
           return;
        }
        // 다음 시간으로 이동
        for(int ny = time + now[0]; ny<= N; ny++) {
            dfs(ny, sum + now[1]);
        }
    }
}
