package main.java.com.exercise.ps.Baekjoon.greedy;

import java.util.*;

public class Q2839_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bag = 0;

        // 5를 최대한쓰고 3을 최소로 사용해야한다.
        // 5로 나눌수있을때까지 3을 빼고 뺀만큼 봉지는 더한다.
        while(N >= 0) {
            if(N % 5 == 0) {
                bag += (N / 5);
                break;
            }
            N -= 3;
            bag += 1;
        }
        if(N < 0) bag = -1;
        System.out.print(bag);
    }
}
