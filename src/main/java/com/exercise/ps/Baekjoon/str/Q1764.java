package main.java.com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            map.put(br.readLine(), 1);
        }

        for(int i=0; i<M; i++) {
            String temp = br.readLine();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if(map.get(temp) == 2) list.add(temp);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(String s : list) System.out.println(s);
    }
}
