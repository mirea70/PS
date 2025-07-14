package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17406 {
    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static List<int[]> operationList;
    // 우하좌상
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};
    static int min_val = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // 이차원 배열 저장
        arr = new int[N+1][M+1];
        for(int r=1; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 연산 리스트 저장
        operationList = new ArrayList<>();
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            operationList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        // 1. 연산 순서를 정하는 순열 뽑기
        // 2. 뽑았을 때마다 배열을 복사 -> 해당 순서로 배열 돌리기
        // 3. 배열 다 돌렸으면 배열 값의 최소값 갱신
        int size = operationList.size();
        perm(size, new boolean[size], new int[size], 0);
        System.out.print(min_val);
    }

    private static void perm(int size, boolean[] visit, int[] current, int depth) {
        if(depth == size) {
            int[][] copied_arr = new int[N+1][M+1];
            for(int r=1; r<=N; r++) {
                copied_arr[r] = arr[r].clone();
            }
            // Todo: 배열 돌리기 실행
            for(int commandIdx : current) {
                rotate(copied_arr, operationList.get(commandIdx));
//                System.out.println(Arrays.deepToString(copied_arr));
            }
            // 배열 값의 최소값 갱신
            updateMin(copied_arr);
            return;
        }

        for(int i=0; i<size; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = i;
                perm(size, visit, current, depth+1);
                visit[i] = false;
            }
        }
    }

     private static void rotate(int[][] copied_arr, int[] command) {
        int r = command[0];
        int c = command[1];
        int s = command[2];

        int sy = r - s;
        int sx = c - s;
        int ey = r + s;
        int ex = c + s;
        int dir = 0;
//         System.out.println("sy, sx = " + sy + ", " + sx);
//         System.out.println("ey, ex = " + ey + ", " + ex);

        boolean[][] visit = new boolean[N+1][M+1];

        int nextVal = arr[sy-1][sx];
        int moveVal = -1;
         // 좌측 끝 부터 우, 하 좌 상 이동을 반복한다.
         int y = sy;
         int x = sx;
//         int count = 0;
         while(true) {
//             System.out.println("y, x =" + y + ", " + x);
//             count++;
             visit[y][x] = true;

             int ny = y + dy[dir];
             int nx = x + dx[dir];
             // 각 경계를 넘었거나 이미 방문했을 경우 꺾는다.

//             System.out.println("ny, nx =" + ny + ", " + nx);
             if(ny > ey || ny < sy || nx > ex || nx < sx || visit[ny][nx]) {
                 // 새로 한바퀴 돌경우 위의 값 넣기
                 if((dir + 1) % 4 == 0) {
//                     System.out.println("log");
//                     System.out.println("y, x =" + y + ", " + x);
//                     System.out.println("val = " + copied_arr[y][x]);
                    copied_arr[y-1][x] = copied_arr[y][x];
                 }

                 dir = (dir + 1) % 4;
                 ny = y + dy[dir];
                 nx = x + dx[dir];
             }

             // 꺾었는데도 다음 위치가 이미 방문했을 경우 반복 종료
             if(visit[ny][nx]) break;

             // 이동할 때, 저장되있던 다음 값을 삽입할 값으로 저장
             moveVal = nextVal;
             // 현재 기준 다음 값를 새롭게 다음 삽입값으로 저장
             nextVal = copied_arr[y][x];
             // 이동할 위치에 현재 값을 넣기
             copied_arr[y][x] = moveVal;
             // 이동
             y = ny;
             x = nx;
         }
//         System.out.println("count = " + count);
     }
    private static void updateMin(int[][] copied_arr) {
//        System.out.println(Arrays.deepToString(copied_arr));
        int val = Integer.MAX_VALUE;
        for(int r=1; r<=N; r++) {
            int row_sum = 0;
            for(int c=1; c<=M; c++) {
                row_sum += copied_arr[r][c];
            }
            val = Math.min(val, row_sum);
        }
        min_val = Math.min(min_val, val);
    }
}
