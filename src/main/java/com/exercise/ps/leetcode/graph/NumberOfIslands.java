package main.java.com.exercise.ps.leetcode.graph;

public class NumberOfIslands {
    private char[][] map;
    private int n;
    private int m;
    private int[] dy = new int[]{1,-1,0,0};
    private int[] dx = new int[]{0,0,-1,1};

    public int numIslands(char[][] grid) {
        map = grid;
        n=grid.length;
        m=grid[0].length;
        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == '1') {
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int y, int x) {
        map[y][x] = 2;
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
            if(map[ny][nx] == '1') dfs(ny, nx);
        }
    }
}
