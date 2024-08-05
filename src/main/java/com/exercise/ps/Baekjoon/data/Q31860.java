package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q31860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 처리
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int k = Integer.parseInt(inputs[2]);

        // 중요도에 따라 계속 순서를 바꿔줘야함 -> 우선순위큐
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        // 더 일을 처리해야할 경우 보유하는 일들

        for(int i=0; i<n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        // 하루씩 일을 진행한다
        int satisfaction = 0;
        int days = 0;
        // 만족도를 담을 리스트
//        List<Integer> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()) {
            int now = pq.poll();
            // 일을 처리
            // 만족도 갱신
            satisfaction = satisfaction/2 + now;
            days++;
            // 만족도 리스트에 넣기
            result.append(satisfaction).append("\n");
            // 해당 일의 중요도 감소
            now -= m;
            // 해당 일의 중요도 > k 이면 큐에 다시 넣기
            if(now > k) pq.add(now);
        }
        System.out.println(days);
        System.out.print(result);
    }
}
