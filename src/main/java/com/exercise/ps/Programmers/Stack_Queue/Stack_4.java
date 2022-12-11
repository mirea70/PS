package com.exercise.ps.Programmers.Stack_Queue;

import java.util.*;

public class Stack_4 {
    public static void main(String[] args) {
        Stack_4_Solution s4 = new Stack_4_Solution();
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println("s4.solution(priorities, location) = " + s4.solution(priorities, location));
    }
}
class Stack_4_Solution {
    public int solution(int[] priorities, int location) {
        int temp = 0;
        int answer = 0;
        boolean chk = false;
        List<Integer> list = new ArrayList<>();
        // Deque 사용 (그냥 큐 사용도됨)
        Deque<Integer> deque = new LinkedList<>();
        // priorities를 덱에 담는다
        for(int doc : priorities) deque.addLast(doc);
        // 덱이 빌때까지 반복
        while (!deque.isEmpty()) {
            // 덱을 poll하여 임시 저장
            temp = deque.poll();
                // 덱을 순회하여 우선순위 높은 것이 존재하면 덱 마지막에 다시 넣는다
                // 인쇄하거나 순서가 바뀔때마다, location의 값을 최신화
                for (int i : deque) {
                    if (i > temp) {
                        chk = true;
                        break;
                    }
                }
            if (chk) {
                deque.addLast(temp);
                if (location == 0) location = deque.size() - 1;
                else location--;
            }
            // 존재하지 않으면, 리스트에 값을 저장(인쇄)
            else {
                list.add(temp);
                // location이 0이고, 인쇄될 때, 저장되는 리스트의 인덱스가 answer
                if (location == 0) {
                    answer = list.size();
                    break;
                } else location--;
            }
            chk = false;
        }
        return answer;
    }
}