package com.exercise.ps;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ecount_2024_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 암호문 입력
        String s = br.readLine();
        // n 입력
        int n = Integer.parseInt(br.readLine());
        // 매칭 정보 저장
        Map<Character, Character> matchMap = new HashMap<>();
        fillMatchMap(matchMap, br, n);
        // 암호문 순회
        for(char c : s.toCharArray()) {
            // - 해독한 문자 차례로 담기
            sb.append(decode(c, matchMap, n));
        }
        // 순회 끝
        // 해독문 출력
        System.out.print(sb);
    }

    // 해독 함수
    private static char decode(char c, Map<Character, Character> matchMap, int n) {
        // 해독 카운트를 센다.
        int cnt = 0;
        // 해독 카운트 < n이면서, 매칭되는 문자가 있을 동안 해독
        while(cnt < n && matchMap.containsKey(c)) {
            cnt++;
            c = matchMap.get(c);
        }
        // cnt >= n이면
        // c를 ?로 치환
        if(cnt >= n)
            c = '?';
        // 해독된 문자 반환
        return c;
    }

    // 매칭 정보 저장
    private static void fillMatchMap(Map<Character, Character> matchMap, BufferedReader br, int n) throws IOException {
        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            char key = st.nextToken().charAt(0);
            char val = st.nextToken().charAt(0);
            matchMap.put(key, val);
        }
    }
}
