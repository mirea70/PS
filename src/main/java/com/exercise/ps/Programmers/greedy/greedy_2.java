package com.exercise.ps.Programmers.greedy;

public class greedy_2 {
    public static void main(String[] args) {

    }
}

class greedy_2_Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int idx = 0;
        // 좌우 이동 횟수를 담을 move
        int move = len - 1;
        // 조작 횟수만 구하면되므로, 위아래와 왼오른쪽을 따로 구한다
        // name 순회
        for(int i=0;i<len;i++){
            // ABCDEFGHIJKLMNOPQRSTUVWXYZ
            // 위아래 : answer에 바로 더해줌
            // 글자 아스키코드 값 <= N 이면 해당 값 - A (위방향 반복 수) 더하기
            if(name.charAt(i) <= 'N') answer += name.charAt(i) - 'A';
                // 글자 아스키코드 값 > N 이면 Z - 해당 값 + 1 (아래방향 반복 수) 더하기
            else answer += 'Z' - name.charAt(i) + 1;
        }
        // 반복문 끝
        for(int i=0;i<len;i++){
            // A를 만나지 않을 경우 : 오른쪽으로만 이동하는 것이 최솟값 : name 길이 - 1회
            // A를 만날 경우 : 오른쪽으로만 이동한 경우와, 왼쪽으로 돌아 이동한 경우 중 작은 값이 최소
            // A의 마지막 위치 idx를 찾는다
            if(i < len - 1 && name.charAt(i+1) == 'A') {
                idx = i;
                while(idx < len - 1 && name.charAt(idx + 1) == 'A') idx++;
                // JAA
                // 왼쪽으로 돌아간 경우 : PA까지 이동수(인덱스값) + PA까지 이동 수 + name 길이 - 1 - PA 위치
                // 유의 : A가 끝까지 있을 경우는 왼쪽으로 이동하지 않아도된다 : PA까지 이동수
                if(idx == len - 1) move = Math.min(move, i);
                    // 세 경우 중 최솟값이 최종 최솟값
                else move = Math.min(move, i + i + len - 1 - idx);
                // 반복문 탈출
                break;
            }
        }
        // 반복문 끝
        // answer에 move를 더해준다
        answer += move;

        return answer;
    }
}