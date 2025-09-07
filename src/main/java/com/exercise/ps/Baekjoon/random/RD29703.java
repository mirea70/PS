package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class RD29703 {
    static int minTime = Integer.MAX_VALUE;
    static char[][] map;
    static int N;
    static int M;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static Queue<int[]> calQ = new ArrayDeque<>();
    static boolean out(int y, int x) {return y < 0 || y >= N || x < 0 || x >= M;}
    static boolean blocked(char c) {return c == 'D';}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 지도를 그리면서 물고기 서식지 위치 저장
        int hy = -1, hx = -1, sy = -1, sx = -1;
        Queue<int[]> tq = new ArrayDeque<>();

        map = new char[N][M];
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<M;j++) {
                char val = line.charAt(j);
                map[i][j] = val;
                if(val == 'F') tq.add(new int[]{i,j});
                else if(val == 'S') {
                    sy = i;
                    sx = j;
                }
                else if(val == 'H') {
                    hy = i;
                    hx = j;
                }
            }
        }
        // 현재 위치 기준 모든 경로의 걸리는 시간 저장
        int[][] distS = bfs(sy,sx);
        // 집 기준 모든 경로의 걸리는 시간 저장
        int[][] distH = bfs(hy,hx);

        // 물고기 위치별 걸리는 시간 계산해서 최소시간 갱신
        while(!tq.isEmpty()) {
            int[] target = tq.poll();
            int y = target[0];
            int x = target[1];

            int sTime = distS[y][x];
            int hTime = distH[y][x];

            if(sTime == -1 || hTime == -1) continue;
            minTime = Math.min(minTime,sTime + hTime);
        }

        System.out.print(minTime != Integer.MAX_VALUE ? minTime : -1);
    }

    private static int[][] bfs(int sy, int sx) {
        calQ.clear();

        int[][] tempMap = new int[N][M];
        for(int[] row : tempMap) {
            Arrays.fill(row, -1);
        }
        tempMap[sy][sx] = 0;
        calQ.add(new int[]{sy, sx});

        while (!calQ.isEmpty()) {
            int[] current = calQ.poll();

            for(int i = 0; i < 4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if(out(ny, nx) || blocked(map[ny][nx]) || tempMap[ny][nx] != -1) continue;

                tempMap[ny][nx] = tempMap[current[0]][current[1]] + 1;
                calQ.add(new int[]{ny,nx});
            }
        }

        return tempMap;
    }
}
