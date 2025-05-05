package com.exercise.ps.Programmers.basic;

import java.util.Stack;

public class Basic103 {
    public int[] solution(int[] arr) {
        int[] answer = {};
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            if(stk.isEmpty()) {
                stk.push(arr[i]);
            }
            else {
                if(stk.peek() == arr[i])
                    stk.pop();
                else
                    stk.push(arr[i]);
            }
        }

        if(stk.isEmpty())
            stk.push(-1);

        answer = new int[stk.size()];

        int idx = 0;
        for(int num : stk) {
            answer[idx] = num;
            idx++;
        }

        return answer;
    }
}
