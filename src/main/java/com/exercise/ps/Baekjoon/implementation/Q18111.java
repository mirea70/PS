package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q18111 {

    private static int[][] map;
    private static int n;
    private static int m;
    private static int time = Integer.MAX_VALUE;
    private static int height = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        int b = Integer.parseInt(arr[2]);
        map = new int[n][m];
        // map 그릴때 최대 높이 저장
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                min = Math.min(min, num);
                map[i][j] = num;
            }
        }
        // 최대 높이부터 맞춰본다
        for(int i=max; i>=min; i--) {
            trys(b,i);
        }
        System.out.print(time + " " + height);
    }
    private static void trys(int b, int target) {
        int t = 0;
        int item = b;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int v = map[i][j];
                if(v == target) continue;
                if(v > target) {
                    item+= v - target;
                    t+= 2 * (v- target);
                }
                else {
                    item-=target - v;
                    t+=target - v;
                }
            }
        }
        if(t < time && item>=0) {
            time = t;
            height = target;
        }
    }
}
