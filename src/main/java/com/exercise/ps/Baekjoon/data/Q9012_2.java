package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        // T번만큼 문자열 판별 - 그때마다 출력
        for(int i=0; i<T; i++) {
            System.out.println(isVps(br.readLine(), stack) ? "YES" : "NO");
            stack.clear();
        }
    }

    // VPS 판별
    private static boolean isVps(String str, Stack<Character> stack) {
        // 문자열 순회
        for(char c : str.toCharArray()) {
            // (일때 : 그냥 넣기
            if(c == '(') {
                stack.add(c);
            }
            // )일 때 : 스택이 비어있거나, 가장최근것이 (가 아니라면 false
            else {
                if(stack.isEmpty() || stack.peek() != '(')
                    return false;
                stack.pop();
            }
        }
        // 스택 비어있지 않으면 false
        if(!stack.isEmpty())
            return false;

        return true;
    }
}
