package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import  java.util.*;

public class Q1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[0]);
        String[] positions = br.readLine().split(" ");

        LinkedList<Integer> dq = new LinkedList<>();
        for(int i=1; i<=n; i++)
            dq.add(i);
        int ans = 0;
        for(String position : positions) {
            int target = Integer.parseInt(position);
            int current = dq.peekFirst();
            if(current != target) {
                if(dq.lastIndexOf(target) <= dq.size()/2) {
                    while(dq.peekFirst() != target) {
                        dq.addLast(dq.pollFirst());
                        ans++;
                    }
                }
                else {
                    while(dq.peekFirst() != target) {
                        dq.addFirst(dq.pollLast());
                        ans++;
                    }
                }
            }
            dq.pollFirst();
        }
        System.out.print(ans);
    }
}
