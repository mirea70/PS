package main.java.com.exercise.ps.Baekjoon.str;

import java.util.*;
import java.io.*;

public class Q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);
        // 우선순위 큐 출력
        for(int i=arr.length-1; i>=0; i--) System.out.print(arr[i]);
    }
}
