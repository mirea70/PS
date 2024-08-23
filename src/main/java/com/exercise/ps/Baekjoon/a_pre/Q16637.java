package com.exercise.ps.Baekjoon.a_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16637 {
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 원본 식 입력
        String str = br.readLine();
        // 연산자 배열 생성
        char[] arr = new char[n/2];
        int index = 0;
        for(int i=0; i<n; i++) {
            if(!Character.isDigit(str.charAt(i))) {
                arr[index] = str.charAt(i);
                index++;
            }
        }
        max = calculate(str);
//        System.out.println(max);
        // 괄호를 어느 연산자에 넣을지 뽑는 조합 실행
//        combination(str, arr, new boolean[n/2], new boolean[n/2], 0, 0);
        combination(str, new boolean[n/2], 0);
        // 최대값 출력
        System.out.print(max);
    }


    private static void combination(String org, boolean[] current, int index) {
        if(index == current.length) {
            String target = applyBrackets(org, current);
            if(validStr(target)) {
                max = Math.max(max, calculate(target));
            }
            return;
        }

        current[index] = false;
        combination(org, current, index+1);

        current[index] = true;
        combination(org, current, index+1);
    }

    private static boolean validStr(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    return false;
                }
                stack.add('(');
            }
            else if(c == ')') {
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
            }
        }
        return true;
    }

    private static String applyBrackets(String str, boolean[] current) {
        StringBuilder sb = new StringBuilder(str);
        int offset = 0; // 괄호를 삽입하면서 생기는 인덱스 차이 조정
        for (int i = 0; i < current.length; i++) {
            if (current[i]) {
                int index = 2 * i + 1 + offset;
                sb.insert(index - 1, "(");
                sb.insert(index + 3, ")");
                offset += 2; // 추가한 괄호 때문에 인덱스 조정
            }
        }
        return sb.toString();
    }

    private static int calculate(String str) {
//        System.out.println(str);
        // 수큐
        Deque<Integer> num_q = new ArrayDeque<>();
        // 연산자큐
        Deque<Character> cal_q = new ArrayDeque<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            // 숫자라면 그냥 넣기
            if(Character.isDigit(c)) {
                num_q.addLast(c - '0');
            }
            // 아니라면
            else {
                // )일 경우
                if(c == ')') {
                    // 연산자에서 1개 뒤에서 뺀다
                    char ca = cal_q.pollLast();
                    // 숫자도 2개 뒤에서 뺀다
                    int num2 = num_q.pollLast();
                    int num1 = num_q.pollLast();
                    // 나중에 뺀놈 연산 먼저뺀놈
                    // 연산 결과를 다시 숫자 큐에 담는다
                    num_q.addLast(cal(ca, num1, num2));
                }
                // (일 경우
                else if (c == '(') {
                }
                // 아닐 경우
                else {
                    // 연산자 큐에 담는다
                    cal_q.addLast(c);
                }
            }
        }
        // 계산
        while (!cal_q.isEmpty()) {
            char ca = cal_q.pollFirst();
            int num1 = num_q.pollFirst();
            int num2 = num_q.pollFirst();

            num_q.addFirst(cal(ca, num1, num2));
        }

        return num_q.poll();
    }

    private static int cal(char ca, int num1, int num2) {
        int result = 0;
        switch (ca) {
            case '+': {
                result = num1 + num2;
            }
            break;
            case '-': {
                result = num1 - num2;
            }
            break;
            case '*': {
                result = num1 * num2;
            }
            break;
        }
        return result;
    }
}
