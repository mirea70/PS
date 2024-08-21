package com.exercise.ps.Baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10808 {
    public static void main(String[] args) throws IOException {
        int zNumeric = (int) 'z';
        int aNumeric = (int) 'a';

        int[] countArr = new int[zNumeric+1];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(char c : str.toCharArray()) {
            int index = (int) c;
            countArr[index]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=aNumeric; i<=zNumeric; i++)
            sb.append(countArr[i]).append(" ");

        sb.setLength(sb.length()-1);

        System.out.print(sb);
    }
}
