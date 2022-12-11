package com.exercise.ps.Programmers.Stack_Queue;

import java.util.*;

public class Stack_3 {
    public static void main(String[] args) {
        int[] progresses = {95,95,95,95};
        int[] speeds = {4,3,2,1}; // 2, 1, 1
        Stack_3_Solution ss = new Stack_3_Solution();
        System.out.println("ss.solution(progresses, speeds) = " + Arrays.toString(ss.solution(progresses, speeds)));
    }
}

class Stack_3_Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        LinkedList<Integer> queue = new LinkedList<>();
        // 모든 작업은 동시에 진행된다
        // progresses를 리스트에 넣는다.
        for(int i : progresses) {
            queue.add(i);
        }

        int cnt = 0;
        // 누적 인덱스
        int n = 0;
        List<Integer> answerList = new ArrayList<>();

        while ((queue.size() != 0)) {
            // 하루가 지날 때마다 progresses 요소들의 값을 speeds만큼 더한다.(100까지)
            for (int i = 0; i < queue.size(); i++) {
                queue.set(i, queue.get(i) + speeds[i+n]);
            }
            System.out.println("queue = " + queue.toString());

            // 100이 되었는데, list의 0번 인덱스가 아직 100이 아니면 기다린다
            // 0번 인덱스가 100이 되면 (0번 인덱스를 계속 확인하여 지운다.) 지울때마다 cnt + 1

            while (!queue.isEmpty() && queue.peekFirst() >= 100) {
                queue.poll();
                n++;
                cnt++;
            }
            // 지우는게 종료되면 answerList에 담고, cnt = 0;
            if(cnt != 0) answerList.add(cnt);
            cnt = 0;
            // list가 0이되면 종료
        }
        // answerList를 배열로 변환
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}