package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            Map<String, Integer> map = new HashMap<>();
            String[] inputs1 = br.readLine().split(",");
            for(String input1 : inputs1) {
                String[] val = input1.split(":");
                map.put(val[0], Integer.parseInt(val[1]));
            }
            String[] inputs2 = br.readLine().split("\\|");
            int min = Integer.MAX_VALUE;
            for(String input2 : inputs2) {
                int max = 0;
                String[] vals = input2.split("&");
                for(String val : vals) {
                    max = Math.max(map.get(val), max);
                }
                min = Math.min(min, max);
            }
            System.out.println(min);
        }
    }
}
