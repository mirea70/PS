package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

import java.util.*;

public class Dfs_Bfs_3_bfs {
    public static void main(String[] args) {
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1, 1}};
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        Dfs_Bfs_3_bfs_Solution b3 = new Dfs_Bfs_3_bfs_Solution();
        System.out.println("b3.solution(maps) = " + b3.solution(maps));
    }
}

class Dfs_Bfs_3_bfs_Solution {
    // 인접노드를 담을 큐
    Queue<int[]> node = new LinkedList<>();
    // 방향 정의 상하좌우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    // 맵 그래프
    int[][] maps;
    // 맵의 크기
    int n;
    int m;
    // 새 위치값
    int nx;
    int ny;
    // 최단거리
    int min = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;
        // 인접 노드를 방문하면서 최단거리를 계속 갱신하여 문제풀이
        // bfs 돈다
        bfs(0, 0);
        if(min == 1) min = -1;
        return min;
    }

    private void bfs(int x, int y) {
        // 시작노드 담기
        node.add(new int[]{x, y});
        // 큐가 빌 때 까지 반복
        while (!node.isEmpty()) {
            int[] cur = node.poll();
            x = cur[0];
            y = cur[1];
            // 현재 노드에서 다음 상하좌우 위치 확인
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                // 미로 공간 벗어날 경우 무시
                if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
                // 벽인 경우 무시
                if (maps[nx][ny] == 0) continue;
                // 해당 노드를 처음 방문하는 경우에만 최단거리 기록
                if (maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    node.add(new int[]{nx, ny});
                }
            }
        }
        min = maps[n-1][m-1];
    }
}
