package main.java.com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q21610 {

    static int N,M;
    static int[][] map;
    // 구름 이동
    static int[] dy1 = new int[]{0,0,-1,-1,-1,0,1,1,1};
    static int[] dx1 = new int[]{0,-1,-1,0,1,1,1,0,-1};
    // 물복사버그 이동
    static int[] dy2 = new int[]{-1,-1,1,1};
    static int[] dx2 = new int[]{-1,1,1,-1};
    // 구름 리스트
    static List<int[]> clouds = new ArrayList<>();

    static int[][] is_cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        is_cloud = new int[N+1][N+1];
        // 맵 그리기
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 최초 구름 지정
        for(int i=1; i<=2; i++) {
            is_cloud[N-1][i] = 1;
            is_cloud[N][i] = 1;
            clouds.add(new int[]{N-1,i});
            clouds.add(new int[]{N,i});
        }
        // 반복문
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            // 명령 수행
            command(dir, s);
        }
        // 반복 끝
        // 바구니 물의 총합 구하기
        int sum = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void command(int dir, int s) {
        // 구름 이동
        for(int[] cloud : clouds) {

            int ny = (N + cloud[0] + dy1[dir] * (s % N)) % N;
            int nx = (N + cloud[1] + dx1[dir] * (s % N)) % N;
//            if(ny > N) ny = ny % N;
//            else if(ny < 1) ny = N + (ny % N);
//            if(nx > N) nx = nx % N;
//            else if(nx < 1) nx = N + (nx % N);

            is_cloud[cloud[0]][cloud[1]] -= 1;
            is_cloud[ny][nx] += 1;
            cloud[0] = ny;
            cloud[1] = nx;

            // 비내리기
            map[ny][nx] += 1;
            // 구름 삭제 -> 2로변환
            is_cloud[ny][nx] = -1;
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(is_cloud[i][j] == 2) is_cloud[i][j] = 1;
            }
        }

        // 물복사버그
        for(int[] cloud : clouds) {
            for(int i =0; i<4; i++) {
                int ny = cloud[0] + dy2[i];
                int nx = cloud[1] + dx2[i];

               if(ny > N || ny < 1 || nx > N || nx < 1) continue;
               if(map[ny][nx] != 0) map[cloud[0]][cloud[1]]++;
            }
        }
        clouds.clear();
        // 구름 생성, 물량 줄이기
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(is_cloud[i][j] == -1) continue;
                if(map[i][j] >= 2) {
                    is_cloud[i][j] = 1;
                    clouds.add(new int[]{i,j});
                    map[i][j] -= 2;
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(is_cloud[i][j] == -1) is_cloud[i][j] = 0;
            }
        }
    }
}
