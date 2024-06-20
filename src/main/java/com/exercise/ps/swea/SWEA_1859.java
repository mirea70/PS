package com.exercise.ps.swea;

import java.util.Scanner;

public class SWEA_1859 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            // 배열에 각 매매가 넣기
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                int val = sc.nextInt();
                arr[i] = val;
            }
            int maxIdx = -1;
            long result = 0;
            // 매매가 배열 최댓값 인덱스가 마지막 전일 때 동안 반복
            while(maxIdx < n-1) {
                int tmpMaxIdx  = -1;
                long max = -1L;
                // 최댓값 인덱스+1 ~ 끝까지 순회해서 최댓값과 그 인덱스 구해 저장
                for(int i= maxIdx+1; i<n; i++){
                    if(arr[i] >= max) {
                        max = (long) arr[i];
                        tmpMaxIdx = i;
                    }
                }
                // 최댓값 인덱스+1 ~ 금방 구한 인덱스 전까지 결과값에 차이 누적
                for(int i= maxIdx+1; i<tmpMaxIdx; i++){
                    result += max - (long)arr[i];
                }
                maxIdx = tmpMaxIdx;
            }
            // 반복 끝
            // 누적값 출력
            System.out.println("#" + test_case + " " + result);
        }
    }
}
