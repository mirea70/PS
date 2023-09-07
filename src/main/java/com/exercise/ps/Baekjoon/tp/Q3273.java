package com.exercise.ps.Baekjoon.tp;

import java.util.*;
import java.io.*;

public class Q3273 {

    // 1 2 3 5 7 9 10 11 12

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        // arr 오름차순 정렬
        Arrays.sort(arr);

        int cnt = 0;
        int s = 0;
        int e = n-1;

        while(true) {
            // e == s 이면 종료
            if(e == s) break;
            // e + s < x 이면 s를 더하고
            if(arr[e]+arr[s] < x) s++;
            // e + s > x 이면 e를 줄인다
            else if(arr[e]+arr[s] > x) e--;
            // e + s == x 이면 cnt++
            else {
                cnt++;
                s++;
            }
        }

        System.out.println(cnt);
    }
}
