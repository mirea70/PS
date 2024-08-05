package main.java.com.exercise.ps.Baekjoon.bruteforce;

import java.util.*;

public class Q1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        // 첫 종말의 수인 666부터 1씩 증가시킨다
        int num = 666;
        int version = 1;
        // version이 input 값과 같다면 반복 끝
        while(version != target) {
            num++;
            // 666이 포함되어 있다면 version을 증가시킨다.
            if(String.valueOf(num).contains("666")) version++;
        }
        // num 출력
        System.out.print(num);
    }
}
