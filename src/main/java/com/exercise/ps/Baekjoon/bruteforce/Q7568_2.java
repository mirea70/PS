package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7568_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        // 각 사람 데이터 배열에 저장
        int[][] datas = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            datas[i][0] = Integer.parseInt(st.nextToken());
            datas[i][1] = Integer.parseInt(st.nextToken());
        }

        // 덩치 데이터 2중 반복 - 등수 등수배열에 저장
        int[] ranks = new int[N];
        for(int i=0; i<N; i++) {
            int rank = 1;
            int weight = datas[i][0];
            int height = datas[i][1];

            for(int j=0; j<N; j++) {
                if(i==j) continue;
                int currenWeight = datas[j][0];
                int currenHeight = datas[j][1];
                if(weight < currenWeight && height < currenHeight)
                    rank++;

            }
            ranks[i] = rank;
        }
        // 등수 배열 순회 - 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++)
            sb.append(ranks[i]).append(" ");
        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }
}
