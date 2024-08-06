package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_19185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String[] input1 = br.readLine().split(" ");
            int n = Integer.parseInt(input1[0]);
            int m = Integer.parseInt(input1[1]);

            // arr1, arr2에 육십갑자 저장
            String[] arr1 = br.readLine().split(" ");
            String[] arr2 = br.readLine().split(" ");
            // 정수 q 받기
            int q = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            // q번 동안
            for(int i=0; i<q; i++) {
                int y = Integer.parseInt(br.readLine());
                // y에 따라 arr1 인덱스, arr2 인덱스 구하기
                int requestIdx1 = (y-1) % n;
                int requestIdx2 = (y-1) % m;
                // 인덱스에 맞는 값을 답변에 추가
                sb.append(arr1[requestIdx1]).append(arr2[requestIdx2]).append(" ");
            }
            // 순회 끝
            // 마지막 공백 제거
            sb.setLength(sb.length()-1);
            // 답변 출력
            System.out.println(sb.toString());
        }
    }
}
