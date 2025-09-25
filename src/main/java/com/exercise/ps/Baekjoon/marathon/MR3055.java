package com.exercise.ps.Baekjoon.marathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MR3055 {
    static char[][] map;
    static int R;
    static int C;

    // 상하좌우
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int INF = 2500;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int sy = -1;
        int sx = -1;

        int ty = -1;
        int tx = -1;
        Queue<int[]> waterQ = new ArrayDeque<>();

        for(int r=0; r<R; r++) {
            String line = br.readLine();

            for(int c=0; c<C; c++) {
                char val = line.charAt(c);
                switch (val) {
                    case 'S': {
                        sy = r;
                        sx = c;
                    }
                    break;
                    case 'D': {
                        ty = r;
                        tx = c;
                    }
                    break;
                    case '*': {
                        waterQ.add(new int[]{r,c});
                    }
                    break;
                }

                map[r][c] = val;
            }
        }

        int res = bfs(waterQ, sy, sx, ty, tx);
        System.out.print(res != -1 ? res : "KAKTUS");
    }

    private static int bfs(Queue<int[]> waterQ, int sy, int sx, int ty, int tx) {
        // 물 bfs 돌려서 각 칸에 물이 도착하는 시간을 미리 저장
        int[][] waterTime = new int[R][C];
        for(int r=0; r<R; r++) {
            Arrays.fill(waterTime[r], INF);
        }

        for(int[] water : waterQ) {
            waterTime[water[0]][water[1]] = 0;
        }

        while(!waterQ.isEmpty()) {
            int[] current = waterQ.poll();

            for(int i=0; i<4; i++) {
                int ny = current[0] + dy[i];
                int nx = current[1] + dx[i];

                if(ny >= R || ny < 0 || nx >= C || nx < 0) continue;
                if((map[ny][nx] == '.' || map[ny][nx] == 'S') && waterTime[ny][nx] == INF) {
                    waterTime[ny][nx] = waterTime[current[0]][current[1]] + 1;
                    waterQ.add(new int[]{ny, nx});
                }
            }
        }

        // 고슴도치 BFS
        int[][] positionMap = new int[R][C];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy, sx, 0});

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // 갈 곳이 벽이거나, 물이 생길 위치이면 패스
                if(ny >= R || ny < 0 || nx >= C || nx < 0) continue;
                if(positionMap[y][x] + 1 >= waterTime[ny][nx]) continue;
                // 갈 곳이 D라면 현재 값 + 1을 리턴
                if(ny == ty && nx == tx) {
                    return positionMap[y][x] + 1;
                }
                // 그게아니고 갈 곳이 .이면 현재 값에 +1을 더한값을 저장한다. 그리고 큐에 담기
                else if(map[ny][nx] == '.' && positionMap[ny][nx] == 0) {
                    positionMap[ny][nx] = positionMap[y][x] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        return -1;
    }
}
