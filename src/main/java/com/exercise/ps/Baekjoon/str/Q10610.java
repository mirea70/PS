package com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;

public class Q10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수가 3의 배수이면서 10의 배수이면 30의 배수이다
        String str = br.readLine();
        String[] arr = str.split("");
        int total = 0;
        for(String s : arr) {
            total += Integer.parseInt(s);
        }
        Arrays.sort(arr);
        if(total % 3 != 0 || !arr[0].equals("0")) {
            System.out.print(-1);
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder();
        for(int i= arr.length -1; i>=0; i--) {
            sb.append(arr[i]);
        }
        System.out.print(sb.toString());
    }
}
