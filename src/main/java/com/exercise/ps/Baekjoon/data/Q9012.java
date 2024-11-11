package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            char[] arr = br.readLine().toCharArray();
            // stack에 쌓는다
            Stack<Character> stack = new Stack<>();
            for(char c : arr) {
                // )라면 앞에것이 (이면 pop
                if(c == ')') {
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.add(c);
                }
                else
                    stack.add(c);
            }
            // 끝까지 반복했을 때 비어있으면 vps
            String ans = "NO";
            if(stack.isEmpty())
                ans = "YES";
            System.out.println(ans);
        }
    }
}
