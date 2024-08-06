package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1966_Bubble {
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
            // 배열을 역순으로 순회
            // 각 요소마다 0번부터 순회하며 swap해가며 최댓값을 차례로 배치시킨다
            for(int i=n-1; i>0; i--) {
                for(int j=0; j<i; j++) {
                    if(arr[j] > arr[j+1]) {
                        int tmp = arr[j+1];
                        arr[j+1] = arr[j];
                        arr[j] = tmp;
                    }
                }
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
