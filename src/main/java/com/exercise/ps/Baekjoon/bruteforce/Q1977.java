package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        int sum = 0;
        if(M == 1) {
            list.add(1);
            sum += 1;
        }
        // M ~ N 순회
        for(int num=M; num<=N; num++) {
            // - 2 ~ 선택된 수 순회
            for(int i=2; i<num; i++) {
                // 자기 자신을 곱했을 때 선택된 수가 나올 경우 선택된 수 리스트에 추가 및 sum에 더하기
                if(i*i == num) {
                    list.add(num);
                    sum += num;
                    break;
                }
            }
            // 순회 끝
        }
        // 순회 끝
        if(!list.isEmpty()) {
            System.out.println(sum);
            System.out.print(list.get(0));
        }
        else {
            System.out.print(-1);
        }
    }
}
