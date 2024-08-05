package main.java.com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1026 {
    public static void main(String[] args) throws IOException {
        // 1 2 3 7 8
        // 6 1 1 1 0
        // A 는 오름차순
        // B 는 내림차순
        // 순회하며 각 곱을 더해 누적

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        List<Integer> A = new LinkedList<>();
        List<Integer> B = new LinkedList<>();
        for(int i=0; i<n; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);
        Collections.sort(B, (o1,o2) -> o2 - o1);
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += A.get(i) * B.get(i);
        }
        System.out.print(sum);
    }
}
