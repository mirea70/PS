package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.math.BigInteger;

public class Q15903 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        String[] input2 = br.readLine().split(" ");
        // 우선순위 큐에 해당 값들을 넣고
        for(String s : input2)
            pq.add(new BigInteger(s));
        // 카드합체를 m번만큼 진행
        for(int i=0; i<m; i++) {
            BigInteger a = pq.poll();
            BigInteger b = pq.poll();
            pq.add(a.add(b));
            pq.add(a.add(b));
        }
        // 우선순위 큐의 값들의 합 출력
        BigInteger sum = pq.stream().reduce(new BigInteger("0"), (o1, o2) -> o1.add(o2));
        System.out.print(sum);
    }
}
