package main.java.com.exercise.ps.Baekjoon.greedy;

import java.util.*;

public class Q2839_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        // 반복
        while(n > 0) {
            // 5로 나눠지는지 확인
            if(n % 5 == 0) {
                // 나눠지면 -> 누적수 바로 몫을 합치고 리턴
                cnt += n/5;
                break;
            }
            else {
                // 안나눠지면
                // 3을뺀다 -> 누적수 + 1
                n-= 3;
                cnt++;
            }
        }
        if(n < 0) cnt = -1;
        System.out.print(cnt);
    }
}
