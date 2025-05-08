package com.exercise.ps.Programmers.basic;

import java.util.Stack;

public class Basic106 {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(stk.isEmpty()) {
                stk.push(arr[i]);
            }
            else {
                if(stk.peek() < arr[i]) {
                    stk.push(arr[i]);
                }
                else {
                    stk.pop();
                    i--;
                }
            }
        }

        if(stk.isEmpty())
            stk.push(-1);

        int[] answer = new int[stk.size()];
        int idx = 0;
        for(int num : stk) {
            answer[idx] = num;
            idx++;
        }

        return answer;
    }
}
