package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4613_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // 각 행의 색깔별로 바꾸는데 드는 비용을 저장하는 이차원 배열
            int[][] cost = new int[n][3];
            // 입력을 받으며 cost 채우기
            for(int r=0; r<n; r++) {
                char[] arr = br.readLine().toCharArray();
                for(int c=0; c<m; c++) {
                    if(arr[c] != 'W') {
                        cost[r][0]++;
                    }
                    if(arr[c] != 'B') {
                        cost[r][1]++;
                    }
                    if(arr[c] != 'R') {
                        cost[r][2]++;
                    }
                }
            }
            // dp 테이블
            int[][] dp = new int[n][3];
            // 첫번째 행 초기화
            dp[0][0] = cost[0][0];
            dp[0][1] = m*n; // 불가능
            dp[0][2] = m*n; // 불가능
            // cost를 사용해서 dp 테이블 채우기 -> 해당 행의 해당 색깔의 최소 누적 갯수
            for(int r=1; r<n; r++) {
                // 흰색 : 이전이 흰색일때만 가능
                dp[r][0] = dp[r-1][0] + cost[r][0];
                // 파란색 : 이전이 흰색 또는 파란색일 때 가능
                dp[r][1] = Math.min(dp[r-1][0], dp[r-1][1]) + cost[r][1];
                // 빨간색 : 이전이 파랑 또는 빨강일때 가능
                dp[r][2] = Math.min(dp[r-1][1], dp[r-1][2]) + cost[r][2];
            }

            System.out.printf("#%d %d%n", t, dp[n-1][2]);
        }
    }
}
