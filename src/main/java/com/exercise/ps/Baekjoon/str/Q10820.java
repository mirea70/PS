package com.exercise.ps.Baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int aChar = (int) 'a';
        int zChar = (int) 'z';
        int AChar = (int) 'A';
        int ZChar = (int) 'Z';
        int zeroChar = (int) '0';
        int nineChar = (int) '9';

        // 소문자, 대문자, 숫자. 공백
        int[] arr = new int[4];
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str == null || str.isEmpty()) break;

            for(char c : str.toCharArray()) {
                int index = (int) c;
                if(aChar <= index && index <= zChar)
                    arr[0]++;
                else if(AChar <= index && index <= ZChar)
                    arr[1]++;
                else if(zeroChar <= index && index <= nineChar)
                    arr[2]++;
                else if(c == ' ')
                    arr[3]++;
            }
            for(int i=0; i<arr.length; i++)
                sb.append(arr[i]).append(" ");
            sb.setLength(sb.length()-1);
            System.out.println(sb);

            sb.setLength(0);
            Arrays.fill(arr, 0);
        }
    }
}
