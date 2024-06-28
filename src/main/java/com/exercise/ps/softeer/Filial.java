package com.exercise.ps.softeer;

import java.io.*;
import java.util.*;

public class Filial {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // map 그리기
        int[][] map = new int[3][3];
        for(int i=0; i<3; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int min = Integer.MAX_VALUE;
        // 이미 가능한지 체크
        boolean arleady = false;
        for(int i=0; i<3; i++) {
            if(map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                arleady = true;
                break;
            }

            if(map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                arleady = true;
                break;
            }
        }
        if(arleady) min = 0;
            // 가능하지 않은경우
        else {
            // map을 순회
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    // 각 값을 기준으로 가로 맞추기 시도
                    int val = arrange(map, i, j, 0);
                    // 맞추는 게 끝나면 비용의 최솟값 갱신
                    min = Math.min(min, val);
                    // 각 값을 기준으로 세로 맞추기 시도
                    int val2 = arrange(map, i, j, 1);
                    // 맞추는 게 끝나면 비용의 최솟값 갱신
                    min = Math.min(min, val2);
                }
            }
            // 순회 끝
        }
        System.out.print(min);
    }

    private static int arrange(int[][] map, int ty, int tx, int dir) {
        int result = 0;
        // ty, tx를 기준으로 방향에 맞춰 비용을 구한다.
        switch(dir) {
            // 가로
            case 0: {
                for(int i=0; i<3; i++) {
                    if(i != tx) {
                        result += Math.abs(map[ty][tx] - map[ty][i]);
                    }
                }
            }
            break;
            // 세로
            case 1: {
                for(int i=0; i<3; i++) {
                    if(i != ty) {
                        result += Math.abs(map[ty][tx] - map[i][tx]);
                    }
                }
            }
            break;
        }
        // 비용을 리턴
        return result;
    }
}

