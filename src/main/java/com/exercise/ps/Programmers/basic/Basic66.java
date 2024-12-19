package com.exercise.ps.Programmers.basic;

import java.util.Scanner;

public class Basic66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int len = a.length();
        char[][] map = new char[len][len];
        for(int i=0; i<len; i++) {
            map[0][i] = a.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map[0].length; i++) {
            sb.append(map[0][i]).append('\n');
        }

        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }
}
