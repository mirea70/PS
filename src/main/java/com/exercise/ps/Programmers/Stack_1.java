package com.exercise.ps.Programmers;

import java.util.*;

public class Stack_1 {
    public static void main(String[] args) {
        int[] arr = {4,4,4,3,3};
        Stack_1_Solution bb = new Stack_1_Solution();
        System.out.println("bb.solution(arr) = " + Arrays.toString(bb.solution(arr)));
    }
}

class Stack_1_Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        Deque<Integer> stack = new LinkedList<>();

        // arr을 순회하며 디큐에 넣는다.
        // 넣을 때 디큐의 맨뒤와 같으면 넣지 않는다.
        for(int i : arr) {
            if(stack.isEmpty() || (!stack.isEmpty() && stack.peekLast() != i) ) stack.add(i);
        }
//        System.out.println("stack.size() = " + stack.size());
        // 디큐를 순회하며 순서 그대로 배열에 넣고 출력
//        System.out.println("stack.peek() = " + stack.peek());
        answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.poll();
        }
        return answer;
    }
}