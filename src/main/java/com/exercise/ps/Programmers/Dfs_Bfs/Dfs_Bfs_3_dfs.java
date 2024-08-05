package main.java.com.exercise.ps.Programmers.Dfs_Bfs;

public class Dfs_Bfs_3_dfs {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
//        int[][] maps = {{1, 1}};

        Dfs_Bfs_3_Solution b3 = new Dfs_Bfs_3_Solution();
        System.out.println("b3.solution(maps) = " + b3.solution(maps));
    }
}
class Dfs_Bfs_3_Solution {
    // 현재 행 위치
    int y;
    // 현재 열 위치
    int x;
    // 목표지점 행 위치
    int n;
    // 목표지점 열 위치
    int m;
    // 지나온 칸의 갯수
    int answer;
    // 갱신중인 최단거리
    int min = Integer.MAX_VALUE;
    // 방문체크 배열
    boolean[][] chk;
    // 원본 맵
    int[][] maps;

    public int solution(int[][] maps) {
        // 검은색 부분 : 갈 수 없는 길 : 값이 0
        // 게임 맵 벗어난 길 : 배열의 인덱스 벗어나면
        // 왔던 칸을 다시 돌아갈 순 없다
        y = 0;
        x = 0;
        this.n = maps.length - 1;
        this.m = maps[0].length - 1;
        this.maps = maps;
        answer = 0;
        chk = new boolean[n+1][m+1];
        // dfs를 처음위치에서 돈다.
        dfs(y,x);
        if(min == Integer.MAX_VALUE) min = -1;

        return min;
    }
    // dfs
    private void dfs(int y, int x) {
        // n, m을 방문했으면 최단거리 갱신
        if(chk[n][m]) {
            min = Math.min(answer, min);
            return;
        }
        // 방문 체크
        chk[y][x] = true;
        // 이동칸수 증가
        answer++;
        // 먼저 남쪽으로 이동 가능한지 확인
        // 만약 현재 행 위치가 n보다 작으면서 && 이동 시 값이 0이거나 (i, j)에서 i == n + 1 이거나 방문했던 칸이 아니면 이동 (재귀)
        if(!((y < n && maps[y+1][x] == 0) || y+1 == n + 1 || chk[y+1][x])) dfs(y+1, x);
        // 아닐 시, 동쪽으로 이동 가능한지 확인
        // 만약 현재 열 위치가 m보다 작으면서 && 이동 시 값이 0이거나 (i, j)에서 j == m + 1 이거나 방문했던 칸이 아니면 이동 (재귀)
        else if (!((x < m && maps[y][x+1] == 0) || x+1 == m + 1 || chk[y][x+1])) dfs(y, x + 1);
        // 아닐 시, 북쪽으로 이동 가능한지 확인
        // 만약 현재 행 위치가 n보다 작으면서 && 이동 시 값이 0이거나 (i, j)에서 i == n + 1 이거나 방문했던 칸이 아니면 이동 (재귀)
        else if (!((y != 0 && maps[y-1][x] == 0) || y-1 == -1 || chk[y-1][x])) dfs(y-1, x);
        // 아닐 시, 서쪽으로 이동 가능한지 확인
        // 만약 현재 열 위치가 m보다 작으면서 && 이동 시 값이 0이거나 (i, j)에서 j == m + 1 이거나 방문했던 칸이 아니면 이동 (재귀)
        else if (!((x != 0 && maps[y][x-1] == 0) || x-1 == -1 || chk[y][x-1])) dfs(y, x - 1);
        // 그것도 아닐 시, answer = -1 리턴
    }
}
