package com.exercise.ps.Baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 길이가 N인 경우 : 1개, 길이가 N-1인 경우 : 2가 한개, 길이가 N-2인 경우 : 2가 두개 OR 3이 1개, 길이가 N-3인 경우 :
        // 1: 1 : 1개
        // 2: 1+1, 2 : 2개
        // 3: 1+1+1, 1+2, 2+1, 3 4개
        // 4 : 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 3+1, 1+3 7개
        // 5 : 1+1+1+1+1, 1+1+2+1, 1+1+1+2, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1, 3+1+1, 1+3+1, 1+1+3, 2+3, 3+2 10개
        // 1이 N개, 1이 N-1개, 1이 N-2개
        // 6 : nCn, n-1C(n-2), n-2C(n-2), n-2C(n-3)  n-3C(n-(n-3)
    }
}
