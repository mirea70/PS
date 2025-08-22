package com.exercise.ps.Baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q18808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 모눈종이 그리기
        int[][] map = new int[N][M];
        // 스티커들을 큐에 담음
        Queue<int[][]> stickerQ = new ArrayDeque<>();
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[n][m];
            for(int r=0; r<n; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<m; c++) {
                    sticker[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            stickerQ.add(sticker);
        }
        // 큐가 빌동안 반복
        main: while(!stickerQ.isEmpty()) {
            int[][] sticker = stickerQ.poll();
            // - 회전 카운트 수가 0 초과일 동안 반복
            int rotateCnt = 4;
            while(rotateCnt--> 0) {
                int n = sticker.length;
                int m = sticker[0].length;
                // - 스티커 아래로 한칸씩 이동해가면서 붙일 수 있는지 체크
                int yAdd = 0;
                while (n + yAdd <= N) {
                    // - x 증가값 초기화
                    int xAdd = 0;
                    // - 오른쪽 이동해가며 체크
                    while(m + xAdd <= M) {
                        boolean flag = true;
                        check: for(int r=0; r<n; r++) {
                            for(int c=0; c<m; c++) {
                                //  0이 아니라면 체크 후 중지
                                if(sticker[r][c] == 1 && map[r+yAdd][c+xAdd] != 0) {
                                    flag = false;
                                    break check;
                                }
                            }
                        }
                        if(flag) {
                            // 스티커를 해당 위치에 삽입하고 다음 스티커로 넘어감
                            for(int r=0; r<n; r++) {
                                for(int c=0; c<m; c++) {
                                    if(sticker[r][c] == 1) {
                                        map[r+yAdd][c+xAdd] = 1;
                                    }
                                }
                            }
                            continue main;
                        }
                        // 오른쪽 이동
                        xAdd++;
                    }
                    // - 스티커 아래로 한칸 이동
                    yAdd++;
                }
                // - 스티커 회전
                sticker = rotate(sticker);
            }
        }
        // 모눈종이 1 개수 세서 출력
        int cnt = 0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(map[r][c] == 1) cnt++;
            }
        }

        System.out.print(cnt);
    }

    private static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] newMatrix = new int[m][n];
        for(int r=0; r<m; r++) {
            for(int c=0; c<n; c++) {
                newMatrix[r][c] = matrix[n-1-c][r];
            }
        }
        return newMatrix;
    }
}
