package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_20551 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            // 사탕들 배열에 저장
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // boolean 값 true 초기화 (가능한지 여부)
            boolean pass = true;
            // 카운트 초기화
            int cnt = 0;
            int result = -1;
            // 2번 > 3번 이면 1이되기전까지 2번 < 3번이 될때까지 먹는다.
            // 2번 > 3번 체크 -> 여전하면 false
            // 먹을때마다 카운트
            // 1번도 마찬가지로 체크
            for(int j=arr.length-2; j>=0; j--) {
                while(arr[j] >= arr[j+1] && arr[j] > 1) {
                    cnt++;
                    arr[j]--;
                }
                if(arr[j] >= arr[j+1]) {
                    pass = false;
                    break;
                }
            }
            // boolean이 true 이면 카운트 값 출력
            // false이면 -1 출력
            if(pass) result = cnt;
            System.out.println("#" + i + " " + result);
        }
    }
}
