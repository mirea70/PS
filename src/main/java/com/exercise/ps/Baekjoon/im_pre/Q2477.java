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
        int[] x_arr = new int[6];
        int[] y_arr = new int[6];
        List<int[]> pairList = new ArrayList<>();
        // 참외밭을 그려나가면서, x와 y 배열에 저장하고
        // x를 키로하는 y값을 저장한다
        // y를 키로하는 x값을 저장한다
        int y = 0;
        int x = 0;
        pairList.add(new int[]{0,0});
        for(int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            switch (dir) {
                case 1: {
                    x += val;
                }
                break;
                case 2: {
                    x -= val;
                }
                break;
                case 3: {
                    y += val;
                }
                break;
                case 4: {
                    y -= val;
                }
                break;
            }
            x_arr[i] = x;
            y_arr[i] = y;
            pairList.add(new int[]{x,y});
        }
        // x,y 배열 정렬
        Arrays.sort(x_arr);
        Arrays.sort(y_arr);
        // x의 가장 큰 값 - 가장 작은값 <- 큰 너비
        int large_width = x_arr[5] - x_arr[0];
        // y의 가장 큰 값 - 가장 작은값 <- 큰 높이
        int large_height = y_arr[5] - y_arr[0];

        // x와 y의 둘째값을 찾는다
        int x_max = 0;
        int x_sec = -1;
        for(int i=5; i>=0; i--) {
            if(Math.abs(x_arr[i]) > Math.abs(x_max)) {
                x_max = Math.abs(x_arr[i]);
            }
        }

        for(int i=4; i>=0; i--) {
            if(Math.abs(x_arr[i]) != x_max && Math.abs(x_arr[i]) > Math.abs(x_sec)) {
                x_sec = x_arr[i];
            }
        }
        int y_max = 0;
        int y_sec = -1;
        for(int i=5; i>=0; i--) {
            if(Math.abs(y_arr[i]) > Math.abs(y_max)) {
                y_max = Math.abs(y_arr[i]);
            }
        }

        for(int i=4; i>=0; i--) {
            if(Math.abs(y_arr[i]) != y_max && Math.abs(y_arr[i]) > Math.abs(y_sec)) {
                y_sec = y_arr[i];
            }
        }
        // x의 최대값 또는 최소값을 key로하는 y값과 일치하는 x값과의 차이가 바로 <- 작은 너비
        int width_standard = -1;
        boolean w_flag = false;
        boolean h_flag = false;
        for(int i=0; i<pairList.size(); i++) {
            int[] pair = pairList.get(i);
            if(pair[0] == x_arr[5] && pair[1] == y_sec) {
                w_flag = true;
            }
            if(pair[1] == y_arr[5] && pair[0] == x_sec) {
                h_flag = true;
            }
        }
        if(w_flag) width_standard = x_arr[5];
        else width_standard = x_arr[0];
        // y값도 마찬가지
        int height_standard = -1;
        if(h_flag) height_standard = y_arr[5];
        else height_standard = y_arr[0];

        int smallWidth = Math.abs(x_sec - width_standard);
        int smallHeight = Math.abs(y_sec - height_standard);

        // 큰 면적 - 작은 면적 출력
        System.out.print((large_height * large_width - smallHeight * smallWidth) * k);
    }
}
