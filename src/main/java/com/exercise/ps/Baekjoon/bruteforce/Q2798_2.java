package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798_2 {
    private static int max = 0;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] src = new int[N];
        for(int i=0; i<N; i++)
            src[i] = Integer.parseInt(st.nextToken());

        // 3장을 뽑는 모든 경우의 수
        // 뽑을 때마다 M 이하이면 최대값 갱신
        pick(src, 0, 0, 0);

        // 최대값 출력
        System.out.print(max);
    }

    private static void pick(int[] src, int depth, int sum, int start) {
        // 3장째이면 현재 합 체크 후 최대값 갱신, 리턴
        if(depth == 3) {
            if(sum <= M)
                max = Math.max(max, sum);
            return;
        }

        for(int i=start; i<src.length; i++) {
            pick(src, depth+1, sum + src[i], i+1);
        }
    }
}
