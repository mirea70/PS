package com.exercise.ps.Baekjoon.tp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q13144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수열 저장
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 투포인터 시작
        long cnt = 0;

        Set<Integer> visited = new HashSet<>();
        int l = 0;
        int r = -1;
        while(l<N) {
            // 다음 값이 중복이기 전까지 r증가
            while(r+1 < N && !visited.contains(arr[r+1])) {
                r++;
                visited.add(arr[r]);
            }
            // r-l+1 값 누적 (연속 수열 경우의 수)
            cnt += r-l+1;
            // l값 방문제거
            visited.remove(arr[l]);
            // l 증가
            l++;
        }
        // 끝
        System.out.print(cnt);
    }
}
