package com.exercise.ps.Baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0;
        double score = 0;
        // 입력값 순회
        for(int i=0; i<20; i++) {
            String[] arr = br.readLine().split(" ");
            double subScore = getSubjectScore(arr[2]);
            if(subScore == -1.0) continue;
            double value = Double.parseDouble(arr[1]);
            // 학점총합 누적
            sum += value;
            // 점수 누적
            score += value * subScore;
            // 반복문 끝
        }
        // 점수 / 학점총합 출력 (소숫점 뒤에서 6자리까지 반올림)
        System.out.print(String.format("%.6f", score / sum));
    }

    private static double getSubjectScore(String str) {
        double res = -1.0;
        switch(str) {
            case "A+": res = 4.5;
            break;
            case "A0": res = 4.0;
            break;
            case "B+": res = 3.5;
            break;
            case "B0": res = 3.0;
            break;
            case "C+": res = 2.5;
            break;
            case "C0": res = 2.0;
            break;
            case "D+": res = 1.5;
            break;
            case "D0": res = 1.0;
            break;
            case "F": res = 0.0;
            break;
        }
        return res;
    }
}
