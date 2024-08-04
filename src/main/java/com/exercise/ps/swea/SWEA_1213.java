package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1; t<=10; t++) {
            int tc = Integer.parseInt(br.readLine());
            // 타겟 문자 입력
            String target = br.readLine();
            // 소스 문자 입력
            String source = br.readLine();
            // 소스 문자열 순회
            int count = 0;
            for(int i=0; i<source.length(); i++) {
                // 타겟 문자의 첫 요소와 같으면 모두 일치하는지 탐색
                if(source.charAt(i) == target.charAt(0)) {
                    boolean flag = true;
                    int src_idx = i+1;
                    for(int tg_idx=1; tg_idx<target.length(); tg_idx++, src_idx++) {
                        if(src_idx >= source.length() || source.charAt(src_idx) != target.charAt(tg_idx)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) count++;
                }
                // 일치 탐색 끝
            }
            // 순회 끝
            // 카운트 출력
            System.out.printf("#%d %d%n", tc, count);
        }
    }
}
