package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int vCount = 0;
        for(int i=0; i<n; i++) {
            int val = Integer.parseInt(st.nextToken());
            if(val == target)
                vCount++;
        }
        System.out.print(vCount);
    }
}
