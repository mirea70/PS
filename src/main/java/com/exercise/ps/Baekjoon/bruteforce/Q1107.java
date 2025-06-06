package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int target = Integer.parseInt(br.readLine());
        int broken_cnt = Integer.parseInt(br.readLine());
        // 고장난 수를 저장
        Set<Integer> brokenNums = new HashSet<>();
        if(broken_cnt > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<broken_cnt; i++) {
                brokenNums.add(Integer.parseInt(st.nextToken()));
            }
        }
        int minPress = Math.abs(target-100);
        // 0 ~ 99999 까지 선택
        outer: for(int num=0; num<=999999; num++) {
            String str = String.valueOf(num);
            // 선택한 수의 자리 중, 고장난 수 있으면 패스
            for(int i=0; i<str.length(); i++) {
                if(brokenNums.contains(str.charAt(i) - '0'))
                    continue outer;
            }
            // 선택한 수 기준 +-로 이동한 카운트 중 더 작은값 갱신
            minPress = Math.min(minPress, str.length() + Math.abs(target - num));
        }

        System.out.print(minPress);
    }
}
