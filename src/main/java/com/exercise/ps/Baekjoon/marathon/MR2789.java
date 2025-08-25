package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MR2789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = new char[]{'C','A','M','B','R','I','D', 'G', 'E'};

        String str = br.readLine();
        for(char c : arr) {
            str = str.replaceAll(String.valueOf(c), "");
        }
        System.out.print(str);
    }

}
