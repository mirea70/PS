package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int tc = Integer.parseInt(br.readLine());
            // 배열 입력받기
            int[][] map = new int[100][100];
            for(int i=0; i<100; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            // for문 한번 돌면서
            int row_max = 0;
            int col_max = 0;
            int leftTop_sum = 0;
            int leftBot_sum = 0;

            for(int i=0; i<100; i++) {
                int row_sum = 0;
                int col_sum = 0;
                for(int j=0; j<100; j++) {
                    // 행의 합
                    row_sum += map[j][i];
                    // 열의 합
                    col_sum += map[i][j];
                }
                // 각 합의 max 값 갱신
                row_max = Math.max(row_max, row_sum);
                col_max = Math.max(col_max, col_sum);
                // 대각선들 합 누적
                // 왼위 -> 오른아래 대각 합
                leftTop_sum += map[i][i];
                // 왼아래 -> 오른위 대각 합
                leftBot_sum += map[99 - i][i];
            }
            // 반복 끝
            // 각합들의 최댓값 구하기
            int rowCol_max = Math.max(row_max, col_max);
            int dia_max = Math.max(leftTop_sum, leftBot_sum);
            int max = Math.max(rowCol_max, dia_max);
            // 최댓값 출력
            System.out.printf("#%d %d%n", tc, max);
        }
    }
}
