package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int n = 1;
        // 준규 나라 : 1 1 1 부터 증가시킨다
        int[] jungue = {1,1,1};
        // 1년부터 무한히 1년씩 증가하는 순회 시작
        // 준규나라 숫자가 E, S, M과 동일할 때 탈출
        while(!(arr[0] == jungue[0] && arr[1] == jungue[1] && arr[2] == jungue[2])) {
            n++;
            // 준규나라 E, S M -> 각각 15 나머지, 28 나머지, 19 나머지 로 진행
            jungue[0] = n % 15 != 0 ? n % 15 : 15;
            jungue[1] = n % 28 != 0 ? n % 28 : 28;
            jungue[2] = n % 19 != 0 ? n % 19 : 19;
        }
        // 순회 끝
        // 우리나라 년수 출력
        System.out.println(n);
    }
}
