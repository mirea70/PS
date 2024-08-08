package com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1부터 계속 더해간 값이 S를 넘어갔을 때의 인덱스 -1값
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int i=1;
        while(sum <= S) {
            sum += i++;
        }
        System.out.print(i-2);
    }
}
