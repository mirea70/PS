package com.exercise.ps.Programmers.Dfs_Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs_Bfs_4 {
    public static void main(String[] args) {
        Dfs_Bfs_4_Solution d4 = new Dfs_Bfs_4_Solution();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String begin = "hit";
//        String target = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log"};
        System.out.println("d4.solution(begin, target, words) = " + d4.solution(begin, target, words));
    }
}
class Dfs_Bfs_4_Solution {
    String[] words;
    String begin;
    String target;
    int answer = 0;
    // 이미 바꿨던 인덱스 체크 배열
    boolean[] chk;
    // 각 단어의 단계를 저장할 배열
    int steps;
    // 임시 인덱스
    int ii;
    //
    int[] temp;

    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.begin = begin;
        this.target = target;
        chk = new boolean[words.length];
//        steps = new int[words.length];
        // begin과 다른 알파벳이 1개인걸 점차 누적해나가기 -> bfs로 풀이
        // bfs를 돈다
        answer = bfs();
        // steps의 해당 인덱스 값이 answer
//        answer = answerStep == -1 ? 0 : answerStep;
        return answer;
    }

    private int bfs() {
        // 기준이 될 단어의 인덱스를 담을 큐
        // 큐에 인덱스와 단계를 같이 담자 (배열을 큐에 담자)
        Queue<int[]> index_q = new LinkedList<>();
        // 큐에 -1을 담는다.
        index_q.add(new int[]{-1, 0});
        // 알파벳 다른 수 카운트
        int dif = 0;
        // 큐가 비기 전까지 반복
        while (!index_q.isEmpty()) {
            // 큐의 탑값이 -1일 때만 큐를 폴
            if(index_q.peek()[0] == -1) index_q.poll();
            // begin = 큐 폴 값
            else {
                temp = index_q.poll();
                ii = temp[0];
                steps = temp[1];
                begin = words[ii];
            }
            // begin == target과 일치하면 bfs 종료
            if(begin.equals(target)) {
                return steps;
            }
            // words를 순회
            for (int i = 0; i < words.length; i++) {
                // 이미 바꾸지 않았으면서, begin과 다른게 하나라면 해당 인덱스를 큐에 담고, 단계 상승, 체크도 칠해준다
                for (int j = 0; j < begin.length(); j++) {
                    if(begin.charAt(j) != words[i].charAt(j)) dif++;
                }
                if(!chk[i] && dif == 1) {
                    chk[i] = true;
                    index_q.add(new int[]{i,++steps});
                }
                dif = 0;
            }
        }
        return 0;
    }
}