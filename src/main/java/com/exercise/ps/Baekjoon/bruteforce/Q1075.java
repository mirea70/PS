package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N_str = br.readLine();
        int F = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(N_str);
        sb.setLength(sb.length()-2);
        String minStr = "";


        for(int fn=0; fn<10; fn++) {
            sb.append(fn);
            for(int sn=0; sn<10; sn++) {
                sb.append(sn);
                if(Integer.parseInt(sb.toString()) % F == 0) {
                    String val = String.valueOf(fn) + sn;
                    if(minStr.isEmpty() || (Integer.parseInt(minStr) > Integer.parseInt(val))) {
                        minStr = val;
                    }
                }
                sb.setLength(sb.length()-1);
            }
            sb.setLength(sb.length()-1);
        }
        System.out.print(minStr);
    }
}
