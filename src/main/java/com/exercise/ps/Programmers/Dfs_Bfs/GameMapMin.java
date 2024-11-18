package com.exercise.ps.Programmers.Dfs_Bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class GameMapMin {
    public int solution(int[][] maps) {
        int answer = -1;

        int n = maps.length;
        int m = maps[0].length;
        // 상하좌우
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        Queue<int[]> q = new ArrayDeque<>();
        // 0,0부터 bfs를 돈다.
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            // - 큐에서 현재위치를 뽑는다
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            // - 현재위치가 n-1,m-1이라면 answer 갱신
            if(y == n-1 && x == m-1) {
                if(answer == -1)
                    answer = maps[y][x];
                else
                    answer = Math.min(answer, maps[y][x]);
            }
            // - 상하좌우 이동 시도
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                // - 경계 벗어나면 패스
                if(ny >= n || ny < 0 || nx >= m || nx < 0)
                    continue;
                // - 아직 방문 전이라면(1이라면) 다음 행선지를 큐에 담는다
                if(maps[ny][nx] == 1) {
                maps[ny][nx] = maps[y][x] + 1;
                q.add(new int[]{ny,nx});
                }
            }
        }
        // bfs 끝

        return answer;
    }
}
