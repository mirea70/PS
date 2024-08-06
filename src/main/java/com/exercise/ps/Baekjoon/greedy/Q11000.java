package main.java.com.exercise.ps.Baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> yet = new PriorityQueue<>((o1,o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        for(int i=0; i<n; i++) {
            String[] arr = br.readLine().split(" ");
            yet.add(Arrays.stream(arr).mapToInt(m->Integer.parseInt(m)).toArray());
        }
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(yet.poll()[1]);
        while(!yet.isEmpty()) {
            int[] now = yet.poll();
            if(now[0] >= room.peek()) {
                room.poll();
            }
            room.add(now[1]);
        }
        System.out.print(room.size());
    }
}
