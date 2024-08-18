package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImTest3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 디스플레이 초기 설정
            boolean[][] display = new boolean[4][n];
            // time < k일동안 디스플레이 키거나 끄기
            int time = 0;
            while (time < k) {
                time++;
                // 디스플레이 순회하며 on -> off
                for(int i=0; i<4; i++) {
                    for(int j=0; j<n; j++) {
                        if((i + j +1) % time == 0) display[i][j] = !display[i][j];
                    }
                }
            }
            int cnt = 0;
            for(int i=0; i<4; i++) {
                for(int j=0; j<n; j++) {
                    if(display[i][j]) cnt++;
                }
            }
            System.out.printf("#%d %d%n", t, cnt);
        }
    }
}
