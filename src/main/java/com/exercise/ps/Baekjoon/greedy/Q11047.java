package com.exercise.ps.Baekjoon.greedy;

import java.util.*;

public class Q11047 {
    public static void main(String[] args) {
        int coin = 0;
        // 첫째줄 입력받기
        Scanner sc = new Scanner(System.in);
        String[] arg = sc.nextLine().split(" ");
        int N = Integer.parseInt(arg[0]);
        int K = Integer.parseInt(arg[1]);
        // N번만큼 숫자를 받아 스택에 저장
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            stack.push(sc.nextInt());
        }
        // 스택이 빌때까지 반복
        while(!stack.isEmpty()) {
            // K <= 0 이면 반복 끝
            if(K <= 0) break;
            // 스택에 있는수를 뽑아 저장
            int num = stack.pop();
            // 해당 수 <= K이면
            if(num <= K) {
                int result = K /num;
                // 나눌 수 있으면 몫을 개수에 누적
                coin += result;
                // K -= 몫 & 해당수
                K -= result * num;
            }
            // 반복 끝
        }
        // 코인 개수 출력
        System.out.print(coin);
    }
}
