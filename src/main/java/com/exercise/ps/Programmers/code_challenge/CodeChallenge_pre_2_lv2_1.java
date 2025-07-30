package com.exercise.ps.Programmers.code_challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class CodeChallenge_pre_2_lv2_1 {
    public int solution(int[] players, int m, int k) {
        int count = 0;
        // 증설 서버의 증설시간을 저장하는 큐
        Queue<Integer> addedServers = new ArrayDeque<>();
        // players 순회
        for(int time=0; time<players.length; time++) {
            // 증설된 서버 중 기한이 지난 서버는 종료한다. (Pop)
            while(!addedServers.isEmpty() && time - addedServers.peek() >= k) {
                addedServers.poll();
            }
            // 플레이어 수를 보고 증설해야할 서버의 수를 계산한다.
            int need = players[time] / m  - addedServers.size();
            // 증설해야할만큼 증설한다. -> 카운트
            while(need--> 0) {
                count++;
                addedServers.add(time);
            }
        }
        // 순회 끝
        // 카운트 반환
        return count;
    }
}
