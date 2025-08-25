package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR30007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while(N--> 0) {
            String[] input = br.readLine().split(" ");
            System.out.println(calculate(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }
    }

    private static int calculate(int a, int b, int x) {
        return a * (x - 1) + b;
    }
}
