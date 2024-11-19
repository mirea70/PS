package com.exercise.ps.Programmers.Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameNumber {
    public int[] solution(int []arr) {
        int[] answer = {};
        // 디큐 사용
        Deque<Integer> dq = new ArrayDeque<>();
        // arr을 순회
        for(int a : arr) {
            // 디큐 비어있으면 그냥 담는다.
            if(dq.isEmpty()) {
                dq.addLast(a);
            }
            else {
                // 디큐가 비어있지 않으면서, 제일 마지막것이 같지 않을때만 담는다
                if(dq.peekLast() != a) {
                    dq.addLast(a);
                }
            }
        }
        // 디큐에 있는놈을 배열로만든다
        answer = new int[dq.size()];
        int i=0;
        while(!dq.isEmpty()) {
            answer[i++] = dq.pollFirst();
        }
        // 반환
        return answer;
    }
}
