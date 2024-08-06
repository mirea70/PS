package main.java.com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int dump_cnt = Integer.parseInt(br.readLine());
            // 배열 입력받기
            int[] boxes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 차이값 100으로 초기화
            int dif = 100;
            // 오름차순 정렬
            Arrays.sort(boxes);
            // 덤프 횟수 > 0일 동안 반복
            while(dump_cnt > 0) {
                // 덤프 시도
                dump_cnt--;
                int result = dump(boxes);
                // 반환 값 = 1이면 그냥 반복 끝내기
                if(result == 1) {
                    dif = result;
                    break;
                }
                // dif 갱신
                dif = result;
            }
            // 반복 끝
            // 차이값 출력
            System.out.printf("#%d %d%n", t, dif);
        }
    }

    private static int dump(int[] arr) {
        // 마지막 인덱스 값 - 0번 인덱스 값 확인
        int lastIdx = arr.length-1;
        int dif = arr[lastIdx] - arr[0];
        if(dif == 1) {
            // 이미 1이면 그냥 1반환
            return 1;
        }
        // 1보다 크면
        // - 마지막꺼 --
        arr[lastIdx]--;
        // - 처음꺼 ++
        arr[0]++;
        // 배열 재정렬
        Arrays.sort(arr);
        // 마지막 - 처음꺼 차이값 리턴
        return arr[lastIdx] - arr[0];
    }
}
