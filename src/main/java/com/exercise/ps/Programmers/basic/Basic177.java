package com.exercise.ps.Programmers.basic;

import java.util.Stack;

public class Basic177 {
    public int[] solution(int[] arr, boolean[] flag) {
        // Stack
        Stack<Integer> stack = new Stack<>();
        // flag, arr 순회
        for(int i=0; i<flag.length; i++) {
            int val = arr[i];
            // flag에 따라 명령 수행
            if(flag[i]) {
                for(int j=0; j<val*2; j++) {
                    stack.add(val);
                }
            }
            else {
                for(int j=0; j<val; j++) {
                    stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}
