package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RD14722 {
    // 서북
    static int[] dy = new int[]{0, -1};
    static int[] dx = new int[]{-1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        // 지도 저장
        int[][] map = new int[n][n];
        for(int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<n; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // bfs -> 최대 개수 갱신
        // 최대 개수 출력
        System.out.print(bfs(map, n));
    }

    private static int bfs(int[][] map, int n) {
        // 각 위치에 먹은 최대값, 마지막 먹은 우유 종류를 기록할 3차원 배열 저장
        Integer[][][] dp = new Integer[n][n][2];
        // 0,0 위치 우유 먹기
        dp[0][0][0] = 0;
        dp[0][0][1] = 2;

        if(map[0][0] == 0) {
            dp[0][0][0] = 1;
            dp[0][0][1] = 0;
        }

        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(r == 0 && c == 0) continue;
                int status = map[r][c];

                for(int i=0; i<2; i++) {
                    int py = r + dy[i];
                    int px = c + dx[i];
                    if(py<0 || py>=n || px<0 || px>=n) continue;

                    int pMax = dp[py][px][0];
                    int pStatus = dp[py][px][1];

                    // 비어있으면 채워주고 시작
                    if(dp[r][c][0] == null && dp[r][c][1] == null) {
                        dp[r][c][0] = pMax;
                        dp[r][c][1] = pStatus;
                    }

                    // 현재 위치 먹을 수 있을 때
                    if((pStatus + 1) % 3 == status) {
                        // 현재 위치가 갱신할 값보다 작을때만 먹기
                        if(dp[r][c][0] < pMax+1) {
                            dp[r][c][0] = pMax + 1;
                            dp[r][c][1] = (pStatus + 1) % 3;
                        }
                    }
                    // 먹을 수 없다면 현재 위치가 이전 값보다 작으면 그냥 갱신
                    else {
                        if(dp[r][c][0] < pMax) {
                            dp[r][c][0] = pMax;
                            dp[r][c][1] = pStatus;
                        }
                    }
                }

            }
        }

//        for(int r=0; r<n; r++) {
//            for(int c=0; c<n; c++) {
//                System.out.print(dp[r][c][0] + "," +  dp[r][c][1] + "  ");
//            }
//            System.out.println();
//        }

        return dp[n-1][n-1][0];
    }
}
