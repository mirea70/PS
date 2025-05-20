package com.exercise.ps.Baekjoon.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] src_arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            src_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(src_arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            System.out.println(binarySearch(src_arr, Integer.parseInt(st.nextToken())));
        }
    }

    private static int binarySearch(int[] src_arr, int target) {
        int l = 0;
        int r = src_arr.length-1;

        while(l<=r) {
            int mid = (l+r)/2;
            if(src_arr[mid] == target) return 1;
            else if(src_arr[mid] > target) r = mid-1;
            else l = mid+1;
        }
        return 0;
    }
}
