package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12100 {
    private static int N;
    private static int[] dy = new int[]{-1,1,0,0};
    private static int[] dx = new int[]{0,0,-1,1};
    private static int[][] origin;
    private static int total_max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        origin = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                origin[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(origin, 0);
        System.out.print(total_max);
    }

    // 상하좌우 이동 재귀 함수
    private static void dfs(int[][] board, int move_count) {
        // 이동횟수가 5번이라면 끝내기
        if(move_count == 5) {
            updateMaxBlock(board);
            return;
        }
        // 상하좌우 방향으로 끝까지 이동시키기
        // 이동시킬 때마다 현재 map을 복사한 놈을 사용해야한다.
        int[][] copied_board;
        for(int dir=0; dir<4; dir++) {
            copied_board = new int[N][N];
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    copied_board[r][c] = board[r][c];
                }
            }
            moveToEnd(copied_board, dir);
            dfs(copied_board ,move_count+1);
        }
    }
    // 끝까지 이동하는 함수
    private static void moveToEnd(int[][] board, int dir) {

        // 블록이 합쳐진 여부
        boolean[][] merged = new boolean[N][N];

        // 이동하려는 방향부터 합쳐야하므로 dir에 따라 시작 인덱스가 달라야함 -> 부등호도 달라야하므로 그냥 for문 중복으로 돌리자;
        switch (dir) {
            case 0: {
                for(int r=1; r<N; r++) {
                    for(int c=0; c<N; c++) {
                        moveToEnd(r, c, dir, board, merged);
                    }
                }
            }
            break;
            case 1: {
                for(int r=N-2; r>=0; r--) {
                    for(int c=0; c<N; c++) {
                        moveToEnd(r, c, dir, board, merged);
                    }
                }
            }
            break;
            case 2: {
                for(int r=0; r<N; r++) {
                    for(int c=1; c<N; c++) {
                        moveToEnd(r, c, dir, board, merged);
                    }
                }
            }
            break;
            case 3: {
                for(int r=0; r<N; r++) {
                    for(int c=N-2; c>=0; c--) {
                        moveToEnd(r, c, dir, board, merged);
                    }
                }
            }
            break;
        }
        // 블록 최댓값 갱신
//        updateMaxBlock(board);
    }

//    private static void moveToEnd(int y, int x, int dir, int[][] board, boolean[][] merged) {
//        // y, x 가 이동할 블록이고
//        // ny, nx가 현재 블록임
//        // 이동할 자신이 0이면 블록이 아니므로 그냥 리턴
//        if(board[y][x] == 0) return;
//
//        int ny = y + dy[dir];
//        int nx = x + dx[dir];
//
//        while (isInRange(ny, nx)) {
//            if (board[ny][nx] == 0) {
//                board[ny][nx] = board[y][x];
//                board[y][x] = 0;
//                y = ny;
//                x = nx;
//                ny = y + dy[dir];
//                nx = x + dx[dir];
//            } else if (board[ny][nx] == board[y][x] && !merged[ny][nx]) {
//                board[ny][nx] *= 2;
//                board[y][x] = 0;
//                merged[ny][nx] = true;
//                break;
//            } else {
//                break;
//            }
//        }
//    }

    private static void moveToEnd(int y, int x, int dir, int[][] board, boolean[][] merged) {
        // y, x 가 이동할 블록이고
        // ny, nx가 현재 블록임
        // 이동할 자신이 0이면 블록이 아니므로 그냥 리턴
        if(board[y][x] == 0) return;

        int ny = y + dy[dir];
        int nx = x + dx[dir];

        // ny와 nx가 벽에 닿을 때까지 지정 방향으로 한칸씩 이동한다.
        while(!(ny >= N || ny < 0 || nx >= N || nx < 0)) {
            // - 존재하지 않을 때
            if(board[ny][nx] == 0) {
                // 그냥 이동한다.
                board[ny][nx] = board[y][x];
                board[y][x] = 0;
            }
            // - 이동할 방향에 자신의 크기와 같을 때 존재할 때
            else if(board[ny][nx] == board[y][x]) {
                // -- 합쳐진적이 없을 경우
                if(!merged[ny][nx]) {
                    // 합친다.
                    merged[ny][nx] = true;
                    board[ny][nx] += board[y][x];
                    board[y][x] = 0;
                }

                break;
            }
            // - 크기가 다른놈이 존재할 때
            else {
                // 이동그만
                break;
            }
            // 다음에 볼 현재 블록 갱신
            y = y + dy[dir];
            x = x + dx[dir];
            // 다음 블록 갱신
            ny = y + dy[dir];
            nx = x + dx[dir];
        }
        // 이동 끝
    }

    private static boolean isInRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    private static void updateMaxBlock(int[][] board) {
//        System.out.println(Arrays.deepToString(board));
        int max = 0;
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                max = Math.max(max, board[r][c]);
            }
        }

        total_max = Math.max(total_max, max);
    }
}
