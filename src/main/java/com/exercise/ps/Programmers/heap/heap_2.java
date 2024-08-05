package main.java.com.exercise.ps.Programmers.heap;

import java.util.*;

public class heap_2 {
    public static void main(String[] args) {
        heap_2_Solution h2 = new heap_2_Solution();
        int[][] jobs = new int[][]{
                {0, 3},{1, 9},{2, 6}
        };
        System.out.println("h22.solution(jobs) = " + h2.solution(jobs));
    }
}
class heap_2_Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int now = 0;
        int[] temp;
        int[] p_temp;

        // jobs를 첫 요소 기준 (요청 시점)으로 오름차순 정렬하는 우선순위 큐에 담는다
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] > i2[0] ? 1 : -1;
            }
        });
        for(int[] job : jobs) q.offer(job);
        // 각 작업의 소요시간 낮은 순의 우선순위 큐
        PriorityQueue<int[]> p_q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] > i2[1] ? 1 : -1;
            }
        });
        // 일반 큐가 빌때까지 반복
        while(!q.isEmpty()) {
            // 일반큐를 탑을 확인해 첫 요소가 now보다 클때만 첫 요소를 now에 담는다
            if(q.peek()[0] > now) now = q.peek()[0];
            // 일반 큐의 탑의 첫 요소 <= now일 동안 일반 큐를 뽑아 소요시간 낮은 순 우선순위 큐에 담음
            while(!q.isEmpty() && q.peek()[0] <= now) {
                p_q.offer(q.poll());
                // 반복문 끝
            }
            // 우선순위 큐가 빌때까지 -> 첫번째 것만
            // 진행시간을 누적시키고
            p_temp = p_q.poll();
            now += p_temp[1];
            // answer에 총합을 누적
            answer += now - p_temp[0];
            // 우선순위 큐에 남아있던 것들을 일반 큐에 다시 넣는다 -> 요청시간 순 자동정렬됨
            while(!p_q.isEmpty()) q.offer(p_q.poll());
            // 반복문 끝
        }
        // answer을 jobs길이만큼 나눔
        answer = answer / jobs.length;

        return answer;
    }
}
