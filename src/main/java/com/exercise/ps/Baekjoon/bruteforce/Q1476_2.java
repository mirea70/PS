package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1476_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rE = Integer.parseInt(st.nextToken());
        int rS = Integer.parseInt(st.nextToken());
        int rM = Integer.parseInt(st.nextToken());
        // 1 1 1 부터 1년씩 증가시킨다.
        int E = 1;
        int S = 1;
        int M = 1;
        // rE, rS, rM 과 모두 일치할 때 중지하고 해당 년도수 출력
        int year = 1;
        while (!(E == rE && S == rS && M == rM)) {
            year++;
            E++;
            if(E > 15) E = 1;

            S++;
            if(S > 28) S = 1;

            M++;
            if(M > 19) M = 1;
        }
        System.out.print(year);
    }
}
