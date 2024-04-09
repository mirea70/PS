package com.exercise.ps.Baekjoon.greedy;

import java.util.*;

public class Q2839 {

    private static int bag = 5000;

    public static void main(String[] args) {
        // 입력 N 받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 값 출력
        setMinBag(N);
        System.out.print(bag);
    }

    private static void setMinBag(int n) {
        int current = n;
        int add = 0;
        while(current >= 0) {
            // current 0이면 add 값으로 갱신
            if(current == 0) {
                bag = Math.min(bag, add);
                break;
            }
            // 3으로 나누기 시도
            int result = getMinBagBy3(current);
            // 0이 아니면 최솟값 갱신
            if(result != 0) bag = Math.min(bag, result + add);
            // current - 5
            current -= 5;
            // add ++
            add++;
        }
        if(bag == 5000) bag = -1;
    }

    private static int getMinBagBy3(int n) {
        // n을 3으로 나눈 나머지가 0이면 몫을 리턴
        if(n % 3 == 0) return n / 3;
        // 아니면 0 리턴
        return 0;
    }

    private static int getMinBagBy5(int n) {
        // n을 5으로 나눈 나머지가 0이면 몫을 리턴
        if(n % 5 == 0) return n / 5;
        // 아니면 0 리턴
        return 0;
    }
}
