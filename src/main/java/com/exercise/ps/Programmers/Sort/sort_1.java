package com.exercise.ps.Programmers.Sort;

import java.util.*;

class sort_1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int[] splited;

        // commands의 길이만큼 반복하는 반복문 순회
        for(int i = 0; i < commands.length; i++){
            // commands의 0번째, 1번째를 통해 배열을 자르고, 2번째 원소의 -1과 그 배열을 num_k에 넣은 리턴 값을 리스트에 담음
            splited = new int[commands[i][1] - commands[i][0] + 1];
            splited = Arrays.copyOfRange(array,commands[i][0] - 1, commands[i][1]);
            list.add(num_k(splited, commands[i][2] - 1));
            // 반복문 끝
        }
        // 리스트를 배열로 바꿔 answer에 담기

        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
    // 잘려진 배열과 원하는 번째를 입력하면 해당 수를 출력하는 메서드
    private int num_k(int[] splited, int k) {
        //그 배열을 정렬한다
        Arrays.sort(splited);
        // 해당 번째 수를 출력해 리턴
        return splited[k];
    }
}
