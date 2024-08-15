package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        // 0번 : 방향, 1번 : 길이
        int[][] field = new int[6][2];
        // 방향과, 길이를 저장해나가면서, 가로, 세로의 최대길이와 그 때의 인덱스를 구한다
        int max_width = 0;
        int max_width_idx = -1;
        int max_height = 0;
        int max_height_idx = -1;

        for(int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            field[i][0] = dir;
            field[i][1] = val;
            if((dir == 1 || dir == 2) && val > max_width) {
                max_width = val;
                max_width_idx = i;
            }
            else if((dir == 3 || dir == 4) && val > max_height) {
                max_height = val;
                max_height_idx = i;
            }
        }
        // 큰 사각형의 면적 : 가로, 세로 최대 길이의 곱
        int large_sum = max_width * max_height;
        // 작은 사각형의 면적 구하기
        // 세로가 가장 긴 변의 양쪽 변의 차이 = 작은 사각형의 가로 길이
        int small_width = Math.abs(field[(max_height_idx + 1) % 6][1] - field[(max_height_idx + 5) % 6][1]);
        // 가로가 가장 긴 변의 양쪽 변의 차이 = 작은 사각형의 세로 길이
        int small_height = Math.abs(field[(max_width_idx + 1) % 6][1] - field[(max_width_idx + 5) % 6][1]);
        // 큰 면적 - 작은 면적 출력
        System.out.print((large_sum - (small_width * small_height)) * k);
    }
}