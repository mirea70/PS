package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        // dq에 1~n 담기
        for(int i=0; i<n; i++) {
            dq.addLast(i+1);
        }
        // dq 개수 > 1 동안
        while (dq.size() > 1) {
            // 제일 위카드 버리기
            dq.pollFirst();
            // 제일 위카드 제일 아래로
            if(dq.size() > 1) {
                Integer a = dq.pollFirst();
                dq.addLast(a);
            }
        }
        System.out.print(dq.poll());
    }
}
