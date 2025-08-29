package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MR30395 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 프리즈 사용인덱스 초기화
        int freezeIdx = -1;
        boolean used = false;
        int ans = 0;
        int cur = 0;
        // N일동안 반복
        for(int day=1; day<=N; day++) {
            cur++;
            // 프리즈 갱신
            if(used && day == freezeIdx + 2) {
                used = false;
            }
            int p = Integer.parseInt(st.nextToken());
            // pi가 0이면 프리즈 사용시도
            if(p == 0) {
                cur--;
                // -> 프리즈 없으면 스트릭 끊김
                if(used) {
                    ans = Math.max(ans, cur);
                    cur = 0;
                }
                // 아니라면 프리즈 사용
                else {
                    used = true;
                    freezeIdx = day;
                }
            }
        }
        ans = Math.max(ans, cur);

        System.out.print(ans);
    }
}
