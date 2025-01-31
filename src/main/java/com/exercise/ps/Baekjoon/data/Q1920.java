package com.exercise.ps.Baekjoon.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 정렬
        Arrays.sort(arr);
        // 수들 받아서 각 수가 존재하는지 판별
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            System.out.println(isContain(Integer.parseInt(st.nextToken())));
        }
    }

    private static int isContain(int num) {
        // 이분 탐색
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = (left+right)/2;

            if(arr[mid] == num)
                return 1;
            else if(arr[mid] > num) {
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return 0;
    }
}
