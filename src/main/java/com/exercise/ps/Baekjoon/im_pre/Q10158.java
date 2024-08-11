package com.exercise.ps.Baekjoon.im_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        x = (x+t) % (2*w);
        y = (y+t) % (2*h);
        if(x > w) x = w - (x - w);
        if(y > h) y = h - (y - h);

        // 현재 위치 출력
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(" ").append(y);
        System.out.print(sb);
    }
}
