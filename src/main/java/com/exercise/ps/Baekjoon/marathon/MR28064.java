package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR28064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] persons = new String[N];
        boolean[][] visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            persons[i] = br.readLine();
        }

        // 사람 배열 이중 순회하며 연결 가능하면 카운트
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i == j) continue;
                if(visit[i][j]) continue;
                if(isConnectable(persons[i], persons[j])) {
                    visit[i][j] = true;
                    visit[j][i] = true;
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    private static boolean isConnectable(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int k = Math.min(aLen, bLen);
        // a가 머리, b가 꼬리
        for(int len=1; len<=k; len++) {
            if(a.substring(aLen - len).equals(b.substring(0, len))) {
                return true;
            }
        }

        // b가 머리, a가 꼬리
        for(int len=1; len<=k; len++) {
            if(b.substring(bLen - len).equals(a.substring(0, len))) {
                return true;
            }
        }

        return false;
    }
}
