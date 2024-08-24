package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] prices = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                prices[i] = Integer.parseInt(st.nextToken());

            int maxIdx = -1;
            long total = 0;
            // prices를 최댓값 인덱스가 마지막일때까지 반복
            while(maxIdx < n-1) {
                int tmpMax = -1;
                int tmpMaxIdx = -1;
                // 최댓값 인덱스를 찾고, 임시 최댓값, 임시 최대값 인덱스에 저장한다.
                for(int i=maxIdx+1; i<n; i++) {
                    if(prices[i] > tmpMax) {
                        tmpMax = prices[i];
                        tmpMaxIdx = i;
                    }
                }
                // 임시 최대값 인덱스까지 마지막으로 찾았던 인덱스 + 1 위치부터 차이를 누적
                for(int i=maxIdx+1; i<tmpMaxIdx; i++) {
                    total += tmpMax - prices[i];
                }
                // 최대값 인덱스 초기화
                maxIdx = tmpMaxIdx;
            }
            // 반복 끝
            // 이익 값 출력
            System.out.printf("#%d %d%n", t, total);
        }
    }
}
