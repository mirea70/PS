package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEQ_20934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            // 컵 담을 3크기 배열 생성
            Double[] arr = new Double[3];
            // 방울 1, 아니면 0을 담는다.
            String[] input = br.readLine().split(" ");
            int k = Integer.parseInt(input[1]);
            switch (input[0]) {
                case "o..": {
                    arr[0] = 1.0;
                    arr[1] = 0.0;
                    arr[2] = 0.0;
                }
                break;
                case ".o.": {
                    arr[1] = 1.0;
                    arr[0] = 0.0;
                    arr[2] = 0.0;
                }
                break;
                case "..o": {
                    arr[2] = 1.0;
                    arr[0] = 0.0;
                    arr[1] = 0.0;
                }
                break;
            }
            // k > 0 일 동안 시뮬레이션
            while(k > 0) {
                // k--
                k--;
                // arr[1] == 0인경우
                if(arr[1] == 0) {
                    // 0번째와 2번째중 최댓값 * 1/2 를 1번에 삽입
                    arr[1] = Math.max(arr[0], arr[2]) / 2;
                    // 0번째, 2번째 = 0
                    arr[0] = 0.0;
                    arr[2] = 0.0;
                }
                // 아닌 경우
                else {
                    // 1번째 값 * 1/2 를 0번 2번에 삽입
                    arr[0] = arr[1] / 2;
                    arr[2] = arr[1] / 2;
                    // 1번째 값 = 0
                    arr[1] = 0.0;
                }
            }
            // 컵 배열 값 중 최댓값의 인덱스 -> 같으면 인덱스가 작은 인덱스 출력
            double max = -1;
            int idx = 0;
            for(int j=0; j<3; j++) {
                if(arr[j] != 0 && arr[j] > max) {
                    max = arr[j];
                    idx = j;
                }
            }
            System.out.println("#" + i + " " + idx);
        }
    }
}

