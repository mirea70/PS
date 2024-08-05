package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_20728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++) {
            // n k 저장
            String[] input1 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int k = Integer.parseInt(input1[1]);
            // 사탕 개수 int 배열 저장
            String[] input2 = br.readLine().split(" ");
            Integer[] arr = new Integer[n];
            for(int j=0; j<n; j++)
                arr[j] = Integer.parseInt(input2[j]);
            // 배열 오름차순 정렬
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            // n-k번까지(포함) min 갱신
            for(int j=0; j<=n-k; j++) {
                int m = arr[j+k-1] - arr[j];
                min = Math.min(m, min);
            }
            // 차이 최솟값 출력
            System.out.println("#" + i + " " + min);
        }
    }
}
