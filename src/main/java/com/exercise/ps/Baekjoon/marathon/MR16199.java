package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int birthYear = Integer.parseInt(input1[0]);
        int birthMonth = Integer.parseInt(input1[1]);
        int birthDay = Integer.parseInt(input1[2]);

        String[] input2 = br.readLine().split(" ");
        int targetYear = Integer.parseInt(input2[0]);
        int targetMonth = Integer.parseInt(input2[1]);
        int targetDay = Integer.parseInt(input2[2]);

        // 만 나이 계산
        // 기준 연도 - 생일연도
        int age1 = targetYear - birthYear;
        // 0보다 클 경우
        if(age1 > 0) {
            // 기준월 < 생일월이면 -1
            // 또는 기준월 = 생일월, 기준일 < 생일일이면 -1
            if(targetMonth < birthMonth || (targetMonth == birthMonth && targetDay < birthDay)) {
                age1--;
            }
        }

        // 세는 나이 계산
        // 기준연도 - 생일연도 + 1
        int age2 = targetYear - birthYear + 1;

        // 연 나이 계산
        // 기준연도 - 생일연도
        int age3 = targetYear - birthYear;

        System.out.println(age1);
        System.out.println(age2);
        System.out.println(age3);
    }
}
