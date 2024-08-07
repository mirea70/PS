package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x != 0) {
                queue.add(x);
            }
            else {
                int res = queue.isEmpty() ? 0 : queue.poll();
                System.out.println(res);
            }
        }
    }
}
