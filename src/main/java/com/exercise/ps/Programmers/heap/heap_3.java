package com.exercise.ps.Programmers.heap;

import java.util.ArrayList;
import java.util.Collections;

public class heap_3 {
}

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();
        // 임시 String 배열
        String[] temp;
        // operations 순회
        for(String operation : operations) {
            temp = operation.split(" ");
            // operation의 0번째가 I이면 리스트에 담고 오름차순 정렬
            if(temp[0].equals("I")) {
                list.add(Integer.parseInt(temp[1]));
                Collections.sort(list);
            }
            // 0번째가 D일때
            else {
                // 1번째가-1이고 리스트가 비어있지 않으면 0번째 제거
                if(temp[1].equals("-1") && !list.isEmpty()) list.remove(0);
                    // 1번째가 1이고 리스트가 비어있지 않으면 마지막 제거
                else if(temp[1].equals("1") && !list.isEmpty()) list.remove(list.size() - 1);
            }
            // 반복문 끝
        }
        answer[0] = list.get(list.size()-1);
        answer[1] = list.get(0);

        // 우선순위 큐 생성
        // PriorityQueue<Integer> q = new PriorityQueue<>();
        // // 내림차순 우선순위 큐
        // PriorityQueue<Integer> r_q = new PriorityQueue<>(new Comparator<Integer>() {
        //     public int compare(int i1, i2) {
        //         return i2 > i1 ? 1 : -1;
        //     }
        // });
        // // 임시 String 배열
        // String[] temp = "";
        // // 임시 숫자
        // int n = 0;
        // // operations를 순회
        // for(String operation : operations){
        // // 공백 단위로 쪼갠 String 배열 operation
        //     temp = operation.split(" ");
        // // operation의 0번째가 I이면 q, r_q에 담는다
        //     if(temp[0].equals("I")) {
        //         q.offer(Integer.palseInt(temp[1]));
        //         r_q.offer(Integer.palseInt(temp[1]));
        //     }
        // // 0번째가 D일때
        //     else if(temp[0].equals("D")){
        // // 1번째가-1이고 큐가 비어있지 않으면 q Poll 하고
        //         if(temp[1].eqauls("-1") && !q.isEmpty()) {
        //             n = q.poll();
        //              // r_q를 피크한 것이 뽑은것과 같으면 r_q도 poll
        //             if(r_q.peek == n) r_q.poll();
        //         }
        // // 1번째가 1이면 큐가 비어있지 않으면 r_q Poll 하고
        //         else {
        //             n = r_q.poll();
        //             // q를 피크한 것이 뽑은것과 같으면 q도 poll
        //             if(q.peek() == n) q.poll();
        //         }
        //     }
        // }
        // // 반복문 끝
        return answer;
    }
}