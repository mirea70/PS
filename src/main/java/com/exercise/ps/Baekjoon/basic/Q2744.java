package com.exercise.ps.Baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] words = br.readLine().toCharArray();

        for(int i=0; i<words.length; i++) {
            char c = words[i];
            if(Character.isUpperCase(c))
                words[i] = Character.toLowerCase(c);
            else
                words[i] = Character.toUpperCase(c);
        }

        System.out.print(words);
    }
}
