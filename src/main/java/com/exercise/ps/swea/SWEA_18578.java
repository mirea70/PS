package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_18578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
//            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 역방향 순회
            int lastIdx = arr.length-1;
            int dif_max = 0;
            for(int i =lastIdx-1; i>=0; i--) {
                // 낙하 시도
                // 시도할 값 저장
                int try_val = arr[i];
                // 시도할 값 > 다음인덱스 값 -> 낙하
                if(try_val > arr[i+1]) {
                    // 낙하시도했던 인덱스 = 0
                    arr[i] = 0;
                    // 현재 인덱스 기준 다음 번호부터 정방향 순회
                    for (int j = i + 1; j < arr.length; j++) {
                        // 마지막 인덱스일 경우
                        if (j == lastIdx) {
                            // 시도값보다 현재값이 작다면
                            if(try_val > arr[j])
                                // 현재값을 바꿔준다
                                arr[j] = try_val;
                            dif_max = Math.max(dif_max, j - i - 1);
                        }
                        // 현재 값 != 0이면서, 시도값보다 작으면
                        else if(arr[j] != 0 && arr[j] < try_val) {
                            // 이전 인덱스에 현재 값 채우기
                            arr[j-1] = arr[j];
                        }
                        // 시도값 <= 현재값일 경우
                        else if(try_val <= arr[j]) {
                            // 낙차최대값 갱신, 반복 종료(낙하 끝)
                            dif_max = Math.max(dif_max, j - i - 1);
                            break;
                        }
                    }
                }
                // 정방향 순회 끝
            }
            // 역방향 순회 끝
            // 낙차 최댓값 출력
            System.out.printf("#%d %d%n", t, dif_max);
        }
    }
}