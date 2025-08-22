package com.exercise.ps.Baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 친구 정보 기반 점수 이차원 배열에 초기화
        int N = Integer.parseInt(br.readLine());
        int INF = 987654321;
        int[][] link_score = new int[N+1][N+1];
        for(int r=1; r<=N; r++) {
            for(int c=1; c<=N; c++) {
                if(r != c) {
                    link_score[r][c] = INF;
                }
            }
        }

        while(true) {
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            if(friend1 == -1 && friend2 == -1) break;

            link_score[friend1][friend2] = link_score[friend2][friend1] = 1;
        }

        // 플로이드 와샬 알고리즘
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(link_score[i][j] > link_score[i][k] + link_score[k][j]) {
                        link_score[i][j] = link_score[i][k] + link_score[k][j];
                    }
                }
            }
        }

        // 각 회원의 점수 정하고, 회장 후보 점수도 구하기
        int[] scores = new int[N+1];
        int targetPoint = INF;
        for(int i=1; i<=N; i++) {
            int max = 0;
            for(int j=1; j<=N; j++) {
                if(link_score[i][j] != INF) {
                    max = Math.max(max, link_score[i][j]);
                }
            }
            scores[i] = max;
            targetPoint = Math.min(targetPoint, max);
        }

        // 회장 후보 구하기
        List<Integer> candidates = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            if(scores[i] == targetPoint) {
                candidates.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(targetPoint).append(" ").append(candidates.size()).append("\n");
        for(int candidate : candidates) {
            sb.append(candidate).append(" ");
        }
        sb.setLength(sb.length() -1);
        System.out.print(sb);
    }
}
