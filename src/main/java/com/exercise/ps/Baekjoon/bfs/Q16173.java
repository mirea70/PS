package com.exercise.ps.Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q16173 {

    private static int N;
    private static int[][] map;
    private static int[] dy = {0, 1};
    private static int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 맵 그리기
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1,1 부터 탐색
        String response = bfs(1,1);
        // 결과물 출력
        System.out.print(response);
    }

    private static String bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 꺼내어 현재 위치를 확인
            int[] now = queue.poll();
            int now_val = map[now[0]][now[1]];
            // 현재 위치값 == -1 이면 승리 문자열 리턴
            if(now_val == -1) return "HaruHaru";

            map[now[0]][now[1]] = -2;
            // 현재 위치 정보를 통해 오른쪽, 아래쪽 갈수있는지 확인
            for(int i=0; i<2; i++) {
                int ny = now[0] + dy[i]*now_val;
                int nx = now[1] + dx[i]*now_val;
                // 갈 방향이 벽 외부이면 안됨
                if(ny > N) continue;
                if(nx > N) continue;
                // 갈 방향이 이미 탐색한 방향이면 시도 X
                if(map[ny][nx] == -2) continue;
                // 갈 수 있으면 큐에 담는다.
                queue.add(new int[]{ny, nx});
            }
        }
        // 그냥 반복이 끝났으면 못간다는 의미이므로 패배 문자열 리턴
        return "Hing";
    }
}
