package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q2164_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // deque에 수들 저장
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1; i<=N; i++) {
            deque.add(i);
        }
        // deque 크기 1보다 클동안 반복
        while(deque.size() > 1) {
            // 제일 위 수 버리기
            deque.removeFirst();
            // 제일 위 수 빼서 제일 마지막에 넣기
            deque.add(deque.pop());
        }
        // 반복 끝
        // 현재 남은 수 빼서 출력
        System.out.print(deque.pop());
    }
}
