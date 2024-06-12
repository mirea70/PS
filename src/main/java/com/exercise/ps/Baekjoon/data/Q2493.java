package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2493 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // int 배열 -> 탑 삽입
        int[] tops = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        // 우선순위 큐 -> 크기작은순 정렬 -> 발사 자료들
        PriorityQueue<int[]> shots = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        // int 배열 -> 출력할 인덱스별 수신 탑
        int[] outputs = new int[n];
        // 탑 역순으로 순회
        for(int i=n-1; i>=0; i--) {
            // 1. 수신 -> 가장끝이 아닐경우 -> 발사 자료들이 있으면
            if(i != n-1) {
                while(!shots.isEmpty() && tops[i] > shots.peek()[1]) {
                    // 현재값이 그 자료의 가장 앞보다 크거나 같을 경우 수신 -> 그 큐값 뽑아서 해당 인덱스 채우기
                    int[] target = shots.poll();
                    outputs[target[0]] = i+1;
                }
            }
            // 2. 발사 -> 처음이 아닐경우 -> 우선순위 큐에 삽입
            if(i != 0)
                shots.add(new int[]{i, tops[i]});
        }
        // 순회 끝
        // 출력 배열 순회하며 stringBuilder 생성 -> 출력
        StringBuilder sb = new StringBuilder();
        for(int output : outputs) {
            sb.append(output).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb.toString());
    }
}
