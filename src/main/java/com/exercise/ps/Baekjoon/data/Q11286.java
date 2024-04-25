package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        for(int i=0; i<n; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command == 0) {
                System.out.println(queue.isEmpty() ? 0 : queue.poll());
            }
            else {
                queue.offer(command);
            }
        }
    }
}
