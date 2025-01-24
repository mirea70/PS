package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        // 1 ~ N 순회
        for(int i=1; i<=N; i++) {
            // 한수인지 체크 - 한수이면 개수 카운트
            if(isHan(i))
                count++;
        }
        // 순회 끝
        // 카운트 출력
        System.out.print(count);
    }

    private static boolean isHan(int num) {
        String num_str = String.valueOf(num);

        int len = num_str.length();
        if(len <= 2) return true;

        int dif = (num_str.charAt(1) - '0') - (num_str.charAt(0) - '0');

        for(int i=2; i<num_str.length(); i++) {
            int cur_dif = (num_str.charAt(i) - '0') - (num_str.charAt(i-1) - '0');
            if(cur_dif != dif)
                return false;
        }

        return true;
    }
}
