package main.java.com.exercise.ps.Programmers.heap;

import java.util.PriorityQueue;

public class heap_1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int q1 = 0;
        int q2 = 0;
        int cnt = 0;
        // 우선순위 큐에 scoville를 담는다
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int sc : scoville) q.offer(sc);
        // 큐의 탑이 K보다 작을 동안 반복
        while(q.peek() < K) {
            // q의 사이즈가 2보다 작으면 반복문 종료
            if(q.size() < 2) break;
            // 하나 빼서 q1에 넣고
            q1 = q.poll();
            // 하나 더 빼서 q2에 넣음
            q2 = q.poll();
            // 우선순위 q에 (q1 + q2 * 2)를 넣는다
            q.offer(q1 + (q2 * 2));
            // cnt++
            cnt++;
        }
        // 반복문 종료
        if(q.peek() < K) answer = -1;
        else answer = cnt;
        // 큐의 탑 확인, 여전히 k보다 작다면 answer = -1
        // 아니라면 answer = cnt;
        return answer;
    }
}
