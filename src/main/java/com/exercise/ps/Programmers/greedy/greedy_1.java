package com.exercise.ps.Programmers.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class greedy_1 {
    public static void main(String[] args) {

    }
}
class greedy_1_Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // answer = n - lost길이
        int answer = n - lost.length;
        // 임시 정수 저장 변수
        int temp = 0;
        // lost의 인덱스
        int idx = 0;
        // 옷을 빌려준걸 체크하는 배열 chk[]
        boolean[] chk = new boolean[reserve.length];
        // 옷을 빌린걸 체크하는 배열 ok[]
        boolean[] ok = new boolean[lost.length];
        // lost를 우선순위 큐에 넣는다 (자동 정렬됨)
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int l : lost) q.add(l);
        // reserve와 lost를 오름차순 정렬한다
        Arrays.sort(reserve);
        Arrays.sort(lost);
        // 여분 들고온 학생이 도난당한 경우가 있는지 미리 체크
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(reserve[j] == lost[i]) {
                    chk[j] = true;
                    ok[i] = true;
                    answer++;
                }
            }
        }
        // 큐가 빌때까지 반복
        while(!q.isEmpty()){
            // 큐에서 값을 하나 빼 저장
            temp = q.poll();
            // !ok[idx]일 경우만 reserve를 순회
            if(!ok[idx]){
                for(int i=0;i<reserve.length;i++){
                    // 큐에서 뺀 값의 -1, +1이 있고 !chk[i], !ok[idx]이면 answer ++하고 chk[] = true
                    if((reserve[i] == temp -1 || reserve[i] == temp + 1) && !chk[i] && !ok[idx]){
                        answer++;
                        chk[i] = true;
                        ok[idx] = true;
                        break;
                    }
                }
            }
            idx++;
        }
        // 반복문 끝
        return answer;
    }
}
