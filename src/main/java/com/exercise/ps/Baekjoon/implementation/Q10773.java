package main.java.com.exercise.ps.Baekjoon.implementation;

import java.util.*;

public class Q10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        // 입력 받을때마다
        for(int i =0; i<K; i++) {
            int input = sc.nextInt();
            // 0이 아니면
            if(input != 0) {
                // 스택에 push
                stack.push(input);
            }
            else {
                // 0이면 스택 pop
                stack.pop();
            }
            // 순회 끝
        }
        // 스택 수들의 합 출력
        int sum = stack.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }
}
