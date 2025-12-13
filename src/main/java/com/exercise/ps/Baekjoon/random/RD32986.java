package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RD32986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // x, y, z 중 가장 짧은 라인의 -1 / 2
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int min = Math.min(x, Math.min(y, z));
        System.out.print(
                x == 3 && y == 3 && z == 3 ? 0
                        : (min-1) / 2
        );
    }
}
