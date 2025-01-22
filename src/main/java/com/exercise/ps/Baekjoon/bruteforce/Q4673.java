package com.exercise.ps.Baekjoon.bruteforce;

import java.io.IOException;

public class Q4673 {
    public static void main(String[] args) throws IOException {
        // 1 ~ 10000 까지 boolean 배열 저장
        boolean[] hasCreators = new boolean[10001];
        // 1 ~ 9973까지 순회
        for(int i=1; i<=9973; i++) {
            // d(n) 돌려서 생성자 있으면 boolean 배열에 결과값 true로 변경
            int result = dn(i);
            if(result <= 10000)
                hasCreators[result] = true;
        }
        // 순회 끝
        // 1 ~ 10000 순회하며 boolean 배열 false이면 출력
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=10000; i++) {
            if(!hasCreators[i])
                sb.append(i).append('\n');
        }
        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }

    private static int dn(int num) {
        String num_str = String.valueOf(num);
        int sum = 0;
        for(char c : num_str.toCharArray())
            sum += c - '0';

        return num + sum;
    }
}
