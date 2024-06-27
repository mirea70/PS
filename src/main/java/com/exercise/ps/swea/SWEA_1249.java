package com.exercise.ps.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SWEA_1249 {
    private static int[] dy = new int[]{1,-1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int[][] map;
    private static int[][] totalMap;
    private static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int n = Integer.parseInt(br.readLine());
            // 맵, 누적맵 그리기
            map = new int[n][n];
            totalMap = new int[n][n];
            check = new boolean[n][n];
            for(int i=0; i<n; i++) {
                int[] input = Arrays.stream(br.readLine().split(""))
                        .mapToInt(Integer::parseInt).toArray();
                map[i] = input;
                totalMap[i] = Arrays.copyOf(input, n);
            }
            // 탐색
            // 최소 비용 출력
            System.out.println("#" + t + " " + bfs(0,0, n));
        }
    }

    private static int bfs(int y, int x, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        // 큐에 시작 위치 넣기
        q.add(new int[]{y,x});
        check[y][x] = true;
        // 큐가 비지 않을 동안 반복
        while(!q.isEmpty()) {
            // 큐에서 현 위치 뽑기
            int[] now = q.poll();
            // 현위치가 n-1,n-1이면 패스
            if(now[0] == n-1 && now[1] == n-1) continue;
            // 상하좌우 이동 시도
            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                // 다음 이동지가 벽 넘어가면 패스
                if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                // 방문하지 않은 경우
                if(!check[ny][nx]) {
                    totalMap[ny][nx] = totalMap[now[0]][now[1]] + map[ny][nx];
                    check[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
//                     이미 방문한 경우 : 누적 지도상 현재 값 + 다음 이동지값 < 누적 지도상 다음 이동지 값
                else {
                    if(totalMap[now[0]][now[1]] + map[ny][nx] < totalMap[ny][nx]) {
                        // 누적지도 상 다음 값 갱신
                        totalMap[ny][nx] = totalMap[now[0]][now[1]] + map[ny][nx];
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
        // 반복 끝
        // 누적 map의 n-1,n-1 값을 리턴
        return totalMap[n-1][n-1];
    }
}
