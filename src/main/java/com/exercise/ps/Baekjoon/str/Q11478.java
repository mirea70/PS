package com.exercise.ps.Baekjoon.str;

import java.util.*;

public class Q11478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        // a ab aba abab ababc b ba bab babc abc bc c
        for(int i=0; i<arr.length; i++) {
            sb.append(arr[i]);
            set.add(sb.toString());
            for(int j=i+1; j<arr.length; j++) {
                sb.append(arr[j]);
                set.add(sb.toString());
            }
            sb.setLength(0);
        }
        System.out.print(set.size());
    }
}
