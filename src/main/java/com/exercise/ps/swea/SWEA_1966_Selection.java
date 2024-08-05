package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1966_Selection {
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
            // 0번부터 시작해서 가장 작은수를 차례대로 구하여 자리를 바꾼다.
            for(int i=0; i<n; i++) {
                int minIdx = i;
                // 최소값의 인덱스를 찾는 반복문
                for(int j=i+1; j<n; j++) {
                    if(arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                // 해당 최소값과 현재 자리를 swap
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
            // 정렬한 배열 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            for(int num : arr) {
                sb.append(num).append(" ");
            }
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}
