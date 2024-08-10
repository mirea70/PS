package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 종이 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        // 커팅 횟수 입력
        int T = Integer.parseInt(br.readLine());
        // 커팅 배열을 입력받으며 저장 -> 가로, 세로 따로
        List<Integer> row_cut_list = new ArrayList<>();
        List<Integer> col_cut_list = new ArrayList<>();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command == 0) row_cut_list.add(Integer.parseInt(st.nextToken()));
            else col_cut_list.add(Integer.parseInt(st.nextToken()));
        }
        // 커팅 배열 오름차순 정렬
        Collections.sort(row_cut_list);
        Collections.sort(col_cut_list);
        // 커팅 배열을 순회하며 현재 커팅 번호를 갱신하며 면적을 구해나가며 max 갱신
        int max = 0;
        int row_start = 0;
        for(int rc=0; rc<=row_cut_list.size(); rc++) {
            int row_end = rc != row_cut_list.size() ? row_cut_list.get(rc) : n;
            int col_start = 0;
            for(int cc=0; cc<=col_cut_list.size(); cc++) {
                int col_end = cc != col_cut_list.size() ? col_cut_list.get(cc) : m;

                int width = col_end - col_start;
                int height = row_end - row_start;
                int sum = width * height;
                max = Math.max(max, sum);

                if(cc < col_cut_list.size())
                    col_start = col_cut_list.get(cc);
            }
            if(rc < row_cut_list.size())
                row_start = row_cut_list.get(rc);
        }
        // 순회 끝
        // 누적된 면적 출력
        System.out.print(max);
    }
}
