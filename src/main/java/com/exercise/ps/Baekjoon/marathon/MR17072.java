package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MR17072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                sb.append(getIntensityCharacter(R, G, B));
            }
            sb.append('\n');
        }
        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }

    private static char getIntensityCharacter(int r, int g, int b) {
        int intensity = 2126 * r + 7152 * g + 722 * b;

        if(intensity < 0) {
            return '%';
        }
        else if(intensity < 510000) {
            return '#';
        }
        else if(intensity < 1020000) {
            return 'o';
        }
        else if(intensity < 1530000) {
            return '+';
        }
        else if(intensity < 2040000) {
            return '-';
        }
        else {
            return '.';
        }
    }
}
