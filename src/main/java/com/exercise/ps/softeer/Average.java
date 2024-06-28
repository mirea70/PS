package com.exercise.ps.softeer;

import java.io.*;

public class Average {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);
        double[] arr = new double[n+1];
        // 점수를 double 배열로 담는다
        String[] input2 = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            arr[i] = Double.parseDouble(input2[i-1]);
        }
        // 구간 입력받으며 평균 계산
        // 계산 후 바로바로 출력
        for(int i=0; i<k; i++) {
            String[] input3 = br.readLine().split(" ");
            int s = Integer.parseInt(input3[0]);
            int e = Integer.parseInt(input3[1]);
            double val = 0.0;
            for(int j=s; j<=e; j++) {
                val += arr[j];
            }
            String ans = String.format("%.2f", val/(e-s+1));
            System.out.println(ans);
        }
    }
}
