package com.exercise.ps.Programmers.code_challenge;

import java.util.Arrays;

public class CodeChallenge_pre_2_lv2_2 {
    public int solution(int[][] info, int n, int m) {
        int size = info.length;
        // 아이템 / B 흔적 개수 별 a 흔적을 작은 값으로 갱신해간다.
        int[][] dp = new int[size+1][m];
        for(int i=1; i<=size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            int a = info[i-1][0];
            int b = info[i-1][1];

            for(int j=0; j<m; j++) {
                // a 사용
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a); // b는 이전 것 그대로 가져오기
                // b 사용
                if(j + b < m) {
                    dp[i][j+b] = Math.min(dp[i][j+b], dp[i-1][j]); // a는 이전 것 그대로 가져오기
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int val : dp[size]) {
            if(min > val && val < n) min = val;
        }

        return min != Integer.MAX_VALUE ? min : -1;
    }
}
