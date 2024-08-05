package main.java.com.exercise.ps.Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2667 {

    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            for(int j=1; j<=N; j++) {
                map[i][j] = str.charAt(j-1) - '0';
            }
        }

        // map 순회
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                // 방문하지 않았고, 1찾으면 bfs 돈다
                if(!visit[i][j] && map[i][j] == 1) {
                    // bfs로 받은 카운트 리스트에 담기
                    list.add(bfs(i, j));
                    // bfs 끝나면 단지수 ++
                    cnt++;
                }
            }
        }
        // map 순회 끝
        // 리스트 오름차순 정렬
        Collections.sort(list);
        // 단지수 출력
        System.out.println(cnt);
        // 리스트 값 출력
        for(int a : list)
            System.out.println(a);
    }

    private static int bfs(int y, int x) {
        // 큐에 넣기
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        // 방문 체크
        visit[y][x] = true;
        int num = 0;
        // 큐 빌때까지 반복
        while(!q.isEmpty()) {
            int[] now = q.poll();
            // 카운트 센다
            num++;
            // 상하좌우 이동 시도
            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];
                // 예외 처리
                if(ny < 1 || ny > N || nx <1 || nx > N) continue;
                if(visit[ny][nx]) continue;
                // 방문 전, 1이면 큐 담기
                if(map[ny][nx] == 1) {
                    q.add(new int[]{ny, nx});
                    visit[ny][nx] = true;
                }
            }
        }
        // 카운트 리턴
        return num;
    }
}
