package main.java.com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            for(int j=0; j<k; j++) {
                String[] inputs = br.readLine().split(" ");
                switch (inputs[0]) {
                    case "I" : {
                        int val = Integer.parseInt(inputs[1]);
                        map.put(val, map.getOrDefault(val, 0)+1);
                    }
                    break;
                    case "D" : {
                        int val = Integer.parseInt(inputs[1]);
                        if(map.isEmpty()) continue;
                        int key = val== -1 ? map.firstKey() : map.lastKey();
                        int value = map.get(key);
                        if(value == 1) map.remove(key);
                        else map.put(key, value-1);
                    }
                    break;
                }
            }
            if(map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
            map.clear();
        }
    }
}
