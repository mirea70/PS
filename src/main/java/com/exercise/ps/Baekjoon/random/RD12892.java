package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RD12892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<int[]> gifts = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st =  new StringTokenizer(br.readLine());
            gifts.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        // 데이터 가격 오름차순 정렬
        gifts.sort((g1,g2) -> g1[0] - g2[0]);
        Deque<int[]> deque = new ArrayDeque<>();
        long max = 0;
        long cur_v = 0;
        // 데이터 순회
        for(int i = 0; i < N; i++) {
//            System.out.println("cur_v = " + cur_v);

            int[] current = gifts.get(i);
            // D이상을 만나면 만족도 최대값을 갱신하고, 데이터를 넣을 수 있을 때까지 헤드를 지워간다.
            if(!deque.isEmpty() && current[0] - deque.peekFirst()[0] >= D) {
                max = Math.max(max, cur_v);
                while(!deque.isEmpty() && current[0] - deque.peekFirst()[0] >= D) {
                    cur_v -= deque.pollFirst()[1];
                }
            }
            // 덱에 담는다. 그리고 만족도를 더해간다.
            deque.addLast(current);
            cur_v += current[1];
            // 순회 끝
        }
        // 만족도 최대값을 한번더 갱신
        max = Math.max(max, cur_v);
        // 최대만족도 출력
        System.out.print(max);
    }
}
