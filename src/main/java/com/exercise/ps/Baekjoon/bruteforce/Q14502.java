package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14502 {
    private static int max_safe_val = 0;
    private static int N;
    private static int M;
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static Queue<Dim2Idx> virusQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 맵 그리기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        virusQ = new ArrayDeque<>();

        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                int val = Integer.parseInt(st.nextToken());
                map[r][c] = val;
                if(val == 2) {
                    virusQ.add(new Dim2Idx(r, c));
                }
            }
        }
        // 벽세우기
        makeBlock(map, 0);
        // 안전영역 최대값 출력
        System.out.print(max_safe_val);
    }

    // 벽 세우기 함수
    private static void makeBlock(int[][] map, int block_cnt) {
        // block_cnt == 3이면 안전영역 갱신, 현재값 0으로 변환, 리턴
        if(block_cnt == 3) {
            spreadVirus(map);
            return;
        }
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                // - 0이면 재귀
                if(map[r][c] == 0) {
                    map[r][c] = 1;
                    makeBlock(map, block_cnt + 1);
                    map[r][c] = 0;
                }
            }
        }
    }

    private static void spreadVirus(int[][] map) {
        // virusQ가 있을동안 바이러스 전파 - 복사 맵 사용
        int[][] copied_map = new int[N][M];
        for(int r=0; r<N; r++)
            copied_map[r] = map[r].clone();

        Queue<Dim2Idx> queue = new ArrayDeque<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (copied_map[r][c] == 2) {
                    queue.add(new Dim2Idx(r, c));
                }
            }
        }

        while(!queue.isEmpty()) {
            Dim2Idx dim2Idx = queue.poll();
            copied_map[dim2Idx.y][dim2Idx.x] = 2;
            // 상하좌우 이동시도
            for(int i=0 ;i<4; i++) {
                int ny = dim2Idx.y + dy[i];
                int nx = dim2Idx.x + dx[i];
                // 벽이면 패스
                if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;
                // 0이면 전파
                if(copied_map[ny][nx] == 0)
                    queue.add(new Dim2Idx(ny, nx));
            }
        }
        // 전파 완료했으면 안전영역 카운트 후, 최대값 갱신
        updateSafeZone(copied_map);
    }

    // 안전 영역 카운트 And 갱신 함수
    private static void updateSafeZone(int[][] map) {
        // 맵 순회하며 0 개수 세기
        int cnt = 0;
        for(int r=0; r<N; r++) {
            for( int c=0; c<M; c++) {
                if(map[r][c] == 0) cnt++;
            }
        }
        // 최대값 갱신
        max_safe_val = Math.max(max_safe_val, cnt);
    }

    private static class Dim2Idx {
        int y;
        int x;

        public Dim2Idx() {}

        public Dim2Idx(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
