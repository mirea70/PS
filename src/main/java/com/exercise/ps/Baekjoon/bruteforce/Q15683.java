package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15683 {
    private static int min_blind_spot = Integer.MAX_VALUE;
    private static int[][] map;
    private static int N;
    private static int M;
    // 동남서북
    private static final int[] dy =  new int[]{0,1,0,-1};
    private static final int[] dx = new int[]{1,0,-1,0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        List<CCTV> cctvList = new ArrayList<>();
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                int val = Integer.parseInt(st.nextToken());
                if(val != 0 && val != 6) {
                    cctvList.add(new CCTV(val, r, c));
                }
                map[r][c] = val;
            }
        }

        selectCctvDirs(cctvList, 0);
        System.out.print(min_blind_spot);
    }

    // CCTV의 방향을 정하는 재귀
    private static void selectCctvDirs(List<CCTV> cctvList, int index) {
        // 모든 cctv의 방향 다 정했으면 사각지대 구하기
        if(index == cctvList.size()) {
            updateBlindSpot(cctvList);
            return;
        }

        // 각 리스트의 방향 결정하기
        CCTV cctv = cctvList.get(index);
        for(int rotate_num=0; rotate_num<getRotateCount(cctv.type); rotate_num++) {
            cctv.rotateNum = rotate_num;
            selectCctvDirs(cctvList, index + 1);
        }
    }

    private static int getRotateCount(int type) {
        switch (type) {
            case 2: return 2;
            case 5: return 1;
            default: return 4;
        }
    }

    // 사각지대 구하는 함수
    private static void updateBlindSpot(List<CCTV> cctvList) {
        // map을 복사한다.
        int[][] copied_map = new int[N][M];
        for(int r=0; r<N; r++) {
            System.arraycopy(map[r], 0, copied_map[r], 0, M);
        }
        // cctv 순회하면서 지정된 방향으로 #을 채운다.
        for(CCTV cctv : cctvList) {
            for(int dir : cctv.dirs) {
                int cur_dir = (dir + cctv.rotateNum) % 4;
                int y = cctv.y;
                int x = cctv.x;

                int ny = y + dy[cur_dir];
                int nx = x + dx[cur_dir];
                // 범위 벗어날 때까지
                while (!(ny >= N || ny < 0 || nx >= M || nx < 0)) {
                    // - 6만나면 끝
                    if(copied_map[ny][nx] == 6)
                        break;
                    // 0이라면 #(-1) 삽입
                    if(copied_map[ny][nx] == 0)
                        copied_map[ny][nx] = -1;

                    ny += dy[cur_dir];
                    nx += dx[cur_dir];
                }
            }
        }
        // 순회 끝
        // map을 순회하며 0 세기
        int count = 0;

        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(copied_map[r][c] == 0) {
                    count++;
                }
            }
        }
        // 사각지대 최소값 업데이트
        min_blind_spot = Math.min(min_blind_spot, count);
    }

    static class CCTV {
        int type;

        int y;
        int x;

        // 동남서북
        // 0123
        List<Integer> dirs;

        int rotateNum;

        public CCTV (int type, int y, int x) {
            dirs = new ArrayList<>();
            switch (type) {
                case 1: {
                    dirs.add(0);
                }
                break;
                case 2: {
                    dirs.addAll(List.of(0, 2));
                }
                break;
                case 3: {
                    dirs.addAll(List.of(0, 3));
                }
                break;
                case 4: {
                    dirs.addAll(List.of(0, 2, 3));
                }
                break;
                case 5: {
                    dirs.addAll(List.of(0, 1, 2, 3));
                }
                break;
            }
            this.type = type;

            this.y = y;
            this.x = x;
            this.rotateNum = 0;
        }
    }
}
