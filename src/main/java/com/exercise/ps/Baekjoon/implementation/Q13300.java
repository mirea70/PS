package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        // 성별 학년 <- 키, 룸 개수 맵
        Map<String, Integer> roomChkMap = new HashMap<>();
        // 성별 학년 <- 키, 현재 룸 인원 수 맵
        Map<String, Integer> curPersonMap = new HashMap<>();
        for(int i=1; i<=n; i++) {
            String input2 = br.readLine();
            // 입력 받으면서 둘 모두 채움
            // 채울 때, 현재 인원이 이미 k이면
            if(curPersonMap.containsKey(input2)) {
                int current = curPersonMap.get(input2);
                if(current == k) {
                    // 룸 개수 증가
                    roomChkMap.put(input2, roomChkMap.getOrDefault(input2, 0) + 1);
                    // 현재 룸 인원 수를 초기화 후, 1더함
                    curPersonMap.put(input2, 1);
                }
                // 아니면 그냥 현재에서 1만 추가
                else {
                    curPersonMap.put(input2, current+1);
                }
            }
            // 처음 넣을 경우
            else {
                roomChkMap.put(input2, roomChkMap.getOrDefault(input2, 0)+1);
                curPersonMap.put(input2, curPersonMap.getOrDefault(input2, 0) + 1);
            }
        }
        // 룸 개수 맵의 values를 모두 더한 값이 정답
        System.out.print(roomChkMap.values().stream().mapToInt(i->i).sum());
    }

    static class Room {
        public int gender;
        public int level;
        public List<Integer> persons;

        public Room(int gender, int level) {
            this.gender = gender;
            this.level = level;
            this.persons = new ArrayList<>();
        }
    }
}
