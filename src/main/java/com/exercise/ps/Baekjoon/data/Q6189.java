package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q6189 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long cnt = 0;
        Stack<Integer> stack = new Stack<>();;
        while(N--> 0) {
            int size = Integer.parseInt(br.readLine());
            // 스택에 자신보다 같거나 작은놈이 있을경우 모두 제거한다.
            while(!stack.isEmpty() && stack.peek() <= size) {
                stack.pop();
            }
            // 스택에 있는 사이즈만큼 전체 합에 더한다.
            cnt += stack.size();
            // 스택에 현재 높이를 담는다.
            stack.push(size);
        }
        // 전체 합 출력
        System.out.print(cnt);
    }
}
