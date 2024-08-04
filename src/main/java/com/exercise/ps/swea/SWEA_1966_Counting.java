package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1966_Counting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            // 배열 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            // 카운팅 정렬
            // 1. 배열 순회 -> 최대값 찾기
            int max = 0;
            for(int i=0; i<n; i++) {
                if(arr[i] > max)
                    max = arr[i];
            }
            // 2. 공간 만들기
            // - 카운트 배열
            int[] count_arr = new int[max+1];
            // - 카운트에 대한 누적합 배열
            int[] total_sum_arr = new int[max+1];
            // - 결과 배열
            int[] result = new int[n];
            // 3. 카운트 배열 채우기
            for(int i=0; i<n; i++) {
                count_arr[arr[i]]++;
            }
            // 4. 누적합 배열 채우기
            total_sum_arr[0] = count_arr[0];
            for(int i=1; i<max+1; i++) {
                total_sum_arr[i] = total_sum_arr[i-1] + count_arr[i];
            }
            // 5. 배열 역방향 순회
            for(int i=n-1; i>=0; i--) {
                // - 누적합 배열에 해당하는 위치 -1번 인덱스에 해당하는 결과 배열 채우기
                int idx = total_sum_arr[arr[i]]-- -1;
                result[idx] = arr[i];
            }
            // 정렬한 배열 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            for(int num : result) {
                sb.append(num).append(" ");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}
