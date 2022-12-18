package com.exercise.ps.Programmers.Stack_Queue;

import java.util.*;

public class Stack_6 {
    public static void main(String[] args) {
        Stack_6_Solution s6 = new Stack_6_Solution();
        int[] prices = {1,2,3,2,3};
        System.out.println("s6.solution(prices) = " + Arrays.toString(s6.solution(prices)));
    }
}
class Stack_6_Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        int time = 0;
        int price = 0;
        // 큐에 prices를 담는다.
        for(int i : prices) queue.add(i);
        // 큐가 비기 전까지 반복
        while (!queue.isEmpty()) {
            // time 초기화
            time = 0;
            // 큐를 폴한 값을 저장 = price
            price = queue.poll();
            // 만약 큐가 비었다면 (꺼낸값이 마지막임) 리스트에 0넣고 바로 끝내기
            if(queue.isEmpty()){
                answerList.add(0);
                break;
            }
            // 큐를 순회하며 값이 자신보다 크거나 같을 동안 time++
            int compare_price = 0;
            Iterator<Integer> it = queue.iterator();
            while (it.hasNext()) {
                compare_price = it.next();
                if(compare_price >= price) time++;
                else {
                    time++;
                    break;
                }
            }
            answerList.add(time);
        }
        // 반목 끝나면 리스트를 배열로 변환
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}