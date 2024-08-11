package com.exercise.ps.Baekjoon.a_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        double C = Double.parseDouble(st.nextToken());

        long count = 0;
        // 시험장 순회
        for(int i=0; i<n; i++) {
            // 총감독 1개 빼고, B만큼 시험장 수 뺀다.
            // 만일 부감독이 총감독보다 더 많이 감독할수있으면 이건하면안된다.
            arr[i] -= B;
            if(arr[i] < 0) arr[i] = 0;
            count++;
            // 그리고 나서 남은 수를 C로 나누는데, 올림으로 구하고, 그 수만큼 감독관 수 카운트
            int sub_num = (int) Math.ceil(arr[i] / C);
            count += sub_num;
        }
        // 순회 끝
        // 감독 수 출력
        System.out.print(count);
    }
}
