package main.java.com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q3190 {

    static int[][] map;
    static int[] dy = new int[]{-1,0,1,0};
    static int[] dx = new int[]{0,1,0,-1};
    static int N,K,L;
    static Queue<int[]> dir_infos = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }
        L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int dir = s.equals("D") ? 1 : -1;
            dir_infos.add(new int[]{time,dir});
        }
        Snake snake = new Snake();
        // 초가 증가하는 반복문 시작
        int time = 0;
        foo:
        while(true) {
            time++;
            // 지정 방향으로 머리 이동
            int ny = snake.y + dy[snake.dir];
            int nx = snake.x + dx[snake.dir];
            // 벽, 자기 자신 몸인지 체크 -> 부딪히면 종료
            if(ny > N || ny < 1 || nx > N || nx < 1) break;
            for(int[] end : snake.end_infos) {
                if(end[0] == ny && end[1] == nx) break foo;
            }
            snake.y = ny;
            snake.x = nx;
            snake.end_infos.add(new int[]{ny,nx});
            // 사과 있으면 사과 없애기
            if(map[ny][nx] == 1) map[ny][nx] = 0;
            // 사과 없으면 뱀 꼬리 pop
            else snake.end_infos.poll();
            // 방향 전환 체크
            if(dir_infos != null && dir_infos.size() > 0 && time == dir_infos.peek()[0]) {
                // 전환해야하면 큐에서 꺼내서 전환
                snake.rotate(dir_infos.poll()[1]);
            }
        }
        System.out.print(time);
    }

    private static class Snake {

        int y;
        int x;
        // 0,1,2,3
        // 상우남좌
        int dir;
        Queue<int[]> end_infos;

        private void rotate(int n) {
            if(n == 1) {
                if(dir == 3) dir = 0;
                else dir = dir + 1;
            }
            else {
                if(dir == 0) dir = 3;
                else dir = dir -1;
            }
        }

        public Snake() {
            y = 1;
            x = 1;
            dir = 1;
            end_infos = new LinkedList<>();
            end_infos.add(new int[]{1,1});
        }
    }
}
