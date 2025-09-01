package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q2493_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        Stack<int[]> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());


        for(int i=0; i<N; i++) {
            int h = Integer.parseInt(st.nextToken());
            // 스택 탑이 비거나 현재 높이보다 크거나 같을때까지 pop
            while (!stack.isEmpty() && stack.peek()[1] < h) {
                stack.pop();
            }
            // 스택 탑이 안비어있으면서 값이 현재 높이보다 크거나 같을경우
            if(!stack.isEmpty()) {
                // - 스택 탑의 인덱스가 현재 위치의 수신 탑 위치임
                ans[i] = stack.peek()[0] + 1;
            }
            // 현재 높이 push
            stack.push(new int[]{i, h});
        }

        StringBuilder sb = new StringBuilder();
        for(int i : ans) {
            sb.append(i).append(" ");
        }
        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }
}
