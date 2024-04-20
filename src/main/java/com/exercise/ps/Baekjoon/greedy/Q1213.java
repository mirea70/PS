package com.exercise.ps.Baekjoon.greedy;

import java.util.*;

public class Q1213 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TreeMap에 쓰일 Comparator 사전순
        Comparator<Character> comparator = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        // 입력값 저장
        TreeMap<Character, Integer> map = new TreeMap<>(comparator);
        char[] arr = sc.nextLine().toCharArray();
        for(char c : arr) {
            int v = map.getOrDefault(c, 0);
            map.put(c, v+1);
        }
        int aloneCnt = 0;
        String aloneAlpha = "";
        // treeMap의 key순회하며, value값의 1/2만큼 채워간다
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            char key = entry.getKey();
            // value가 홀수이면 따로 빼두어 개수, 해당 문자열 모두 저장
            if(cnt % 2 != 0) {
                aloneCnt++;
                aloneAlpha = String.valueOf(key);
            }

            for(int i=0; i< cnt/2; i++) {
                sb.append(key);
            }
        }
        String answer = "";
        // 홀수 개수가 2개이상이면 실패 문자열
        if(aloneCnt >= 2) answer = "I'm Sorry Hansoo";
        else {
            answer = sb.toString();
            // 아까 채웠던 문자의 reverse 별도 저장
            String mirror = sb.reverse().toString();
            // 1개이면 결과값에 채우기
            answer += aloneAlpha;
            // reverse 문자열 그대로 채우기
            answer += mirror;
        }
        // 결과 출력
        System.out.print(answer);
    }
}
