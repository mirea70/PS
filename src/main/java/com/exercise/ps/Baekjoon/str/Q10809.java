package com.exercise.ps.Baekjoon.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aNumeric = (int) 'a';
        int zNumeric = (int) 'z';

        int[] positionArr = new int[zNumeric+1];
        Arrays.fill(positionArr, -1);

        int i=0;
        for(char c : str.toCharArray()) {
            int index = (int) c;
            if(positionArr[index] == -1)
                positionArr[index] = i;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(int j=aNumeric; j<=zNumeric; j++)
            sb.append(positionArr[j]).append(" ");
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}
