package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                if(st.nextToken().equals("0")) cnt++;
            }
            System.out.println(getRes(cnt));
            cnt =0;
        }
    }

    private static String getRes(int cnt) {
        String res = "";
        switch (cnt) {
            case 1: res = "A";
            break;
            case 2: res = "B";
            break;
            case 3: res = "C";
                break;
            case 4: res = "D";
                break;
            case 0: res = "E";
                break;
        }
        return res;
    }
}
