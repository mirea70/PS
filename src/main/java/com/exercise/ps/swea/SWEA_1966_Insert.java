package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1966_Insert {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 삽입 정렬
            // i : 1번부터 순회
            for(int i=1; i<n; i++) {
                int target = arr[i];
                // j : i-1부터 역순으로 순회
                int j;
                // j >=0 이거나 arr[j] > target일 동안 반복
                for(j=i-1; j>=0 && arr[j] >target; j--) {
                    // arr[j] 와 arr[j+1] 자리를 바꾸기
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                // 반복이 끝났으면 j가 -1이거나 target보다 작은 놈의 위치일 것이므로
                // j+1 자리에 target을 위치시킨다.
                arr[j+1] = target;
            }
            // 정렬된 배열 출력
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            for(int num : arr)
                sb.append(num).append(" ");
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}
