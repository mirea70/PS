package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> priority = new ArrayList<>();
        priority.add('(');
        priority.add('+');
        priority.add('*');

        for (int t=1; t<=10; t++) {
            int n = Integer.parseInt(br.readLine());
            // 문자열 입력 받아 저장
            String input = br.readLine();
            Stack<Character> calStack = new Stack<>();
            Queue<Character> printQueue = new ArrayDeque<>();
            int result = 0;
            // n번만큼 문자열 순회
            for(int i=0; i<n; i++) {
                char val = input.charAt(i);
//                1. 숫자일 때 : 출력 q에 삽입
                if(Character.isDigit(val)) {
                    printQueue.add(val);
                }
                else {
//                3. (일 때 : 연산자 스택에 push
                    if(val == '(') calStack.add(val);
//                4. )일 때 : 스택 최상단이 (일때까지 pop -> 출력q 삽입, (도 pop으로 제거
                    else if(val == ')') {
                        while(calStack.peek() != '(') {
                            printQueue.add(calStack.pop());
                        }
                        calStack.pop();
                    }
//                2. 연산자일 때 :
                    else {
//                2-1 스택 비어있을 경우 : 연산자 스택에 push
                        if(calStack.isEmpty()) calStack.add(val);
//                2-2 비어있지 않을 경우 : 스택 최상단 문자와 비교
                        else {
//                2-2-1 현재 연산자가 최상단 연산자보다 우선순위 높을 경우 : 연산자 스택에 push
                            if(priority.lastIndexOf(val) > priority.lastIndexOf(calStack.peek())) calStack.add(val);
//                2-2-2 그렇지 않을 경우 :
                            else {
//                - 최상단이 자신보다 낮은 연산자일 때까지 연산자 스택 pop -> 출력 q에 삽입
                                while(priority.lastIndexOf(calStack.peek()) >= priority.lastIndexOf(val)) {
                                    printQueue.add(calStack.pop());
                                }
//                - 현재 연산자를 연산자 스택에 push
                                calStack.add(val);
                            }
                        }
                    }
                }
            }
            // 아직 calStack 남아있으면
            while(!calStack.isEmpty()) {
                // 모두 출력 q에 삽입
                printQueue.add(calStack.pop());
            }
            // 출력 q 빌때까지 꺼내면서 계산
            int tmp = 0;
            Stack<Integer> numStack = new Stack<>();
            while (!printQueue.isEmpty()) {
                char c = printQueue.poll();
                if(Character.isDigit(c)) {
                    numStack.add(Character.getNumericValue(c));
                }
                else {
                    int n2 = numStack.pop();
                    int n1 = numStack.pop();
                    int middle = 0;
                    switch (c) {
                        case '+' : middle = n1 + n2;
                        break;
                        case '*' : middle = n1 * n2;
                        break;
                    }
                    numStack.add(middle);
                }
            }
            result = numStack.pop();
            // 결과값 출력
            System.out.println("#" + t + " " + result);
        }
    }
}
