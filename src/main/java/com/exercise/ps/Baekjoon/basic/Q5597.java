package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[31];

        for(int i=1; i<=28; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=30; i++) {
            if(!arr[i])
                sb.append(i).append("\n");
        }
        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }
}
