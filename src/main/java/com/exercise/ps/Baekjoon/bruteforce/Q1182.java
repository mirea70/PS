package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {
    private static int cnt = 0;
    private static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // N개 숫자의 1개 ~ N개 부분수열을 뽑는다.
        for(int pick_num=1; pick_num<=N; pick_num++) {
            combination(arr, new boolean[N], 0, 0, 0, pick_num);
        }
        // 갯수 출력
        System.out.print(cnt);
    }

    private static void combination(int[] arr, boolean[] visit, int sum, int start, int depth, int r) {
        // 뽑을 때마다 S와 같으면 갯수를 갱신한다.
        if(depth == r) {
            if(sum == S) cnt++;
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(arr, visit, sum + arr[i], i+1, depth+1, r);
                visit[i] = false;
            }
        }
    }
}
