package com.exercise.ps.Programmers;

import java.util.*;

public class Stack_2 {
    public static void main(String[] args) {
        String s = "(()(";
        Stack_2_Solution s2 = new Stack_2_Solution();
        System.out.println("s2.solution(s) = " + s2.solution(s));
    }
}
class Stack_2_Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        // s를 char[]로 변환해 순회하며 스택에 넣는다
        char[] chars = s.toCharArray();
        for(char ch : chars) {
            // ")" 일 때 스택이 비어있거나 스택의 탑이 ")"이면 리턴 false
            if(ch == ')') {
                if(stack.isEmpty() || stack.peek() == ')') {
                    return false;
                } else {
                    // 그것이 아니고, 스택의 탑이 "(" 이면 그 탑을 스택에서 지운다.
                    stack.pop();
                }
                // "("이면 그냥 넣는다.
            } else {
                stack.push(ch);
            }
        }
        // 반복문 종료 : 스택이 비어있지 않으면 리턴 false
        if(!stack.isEmpty()) return false;

        return true;
    }
}
