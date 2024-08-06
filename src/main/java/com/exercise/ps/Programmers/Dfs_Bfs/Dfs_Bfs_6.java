package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs_Bfs_6 {
    public static void main(String[] args) {
        Dfs_Bfs_6_Solution d6 = new Dfs_Bfs_6_Solution();
        int[][] rectangle = new int[][]{
                {1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}
        };
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println("d6 = " + d6.solution(rectangle, characterX,characterY,itemX,itemY));

    }
}

class Dfs_Bfs_6_Solution {
    int itemX;
    int itemY;
    int[][] rectangle;
    int[][] map;
    // x축, y축 이동방향
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    // 이동할 좌표
    int nx;
    int ny;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        this.rectangle = rectangle;
        this.itemX = 2 * itemX;
        this.itemY = 2 * itemY;

        map = new int[101][101];

        // 좌표값 두배로 테두리에 1, 내부엔 2를 채운다.
        for (int i = 0; i < rectangle.length; i++) {
            fill(2 * rectangle[i][0], 2 * rectangle[i][1], 2 * rectangle[i][2], 2 * rectangle[i][3]);
        }

        // 이동가능한 경로를 따라 이동횟수를 누적시켜 나가자 <- BFS
        // map 상 아이템 위치의 값이 최단거리이다
        answer = bfs(2 * characterX, 2 * characterY);
        return answer / 2;
    }

    private void fill(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (map[i][j] == 2) continue;
                if (i == x1 || i == x2 || j == y1 || j == y2) map[i][j] = 1;
                else map[i][j] = 2;
            }
        }
    }

    private int bfs(int x, int y) {
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        // 현재 위치 받고 큐에 넣는다
        queue.add(new int[]{x, y});
        // 큐 빌때까지 반복
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            x = now[0];
            y = now[1];
            if (x == itemX && y == itemY) break;
            // 상하좌우 이동 시도
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                // x, y축 범위 벗어난 경우 pass
                if (nx < 0 || nx > 100 || ny < 0 || ny > 100) continue;
                // 테두리 위에 없거나 이미 방문한 경우 pass
                if (map[nx][ny] != 1 || visited[nx][ny]) continue;
//                if(!isBoundary(nx,ny)) continue;
                // 처음 방문하는 좌표에만 (map 값이 1인경우에만 이동수 누적)
                if (map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[x][y] + 1;
                    // 그리고 그 좌표를 큐에 넣는다
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        // 모두 값을 채우고 map의 아이템 좌표의 값 리턴
        return map[itemX][itemY];
    }
}
