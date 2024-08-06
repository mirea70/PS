package main.java.com.exercise.ps.Baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1260 {

    static List<Integer> dfs_list = new ArrayList<>();
    static List<Integer> bfs_list = new ArrayList<>();
    static boolean[] dfs_visit, bfs_visit;
    static int[][] map;
    static int N, M, V;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        dfs_visit = new boolean[N+1];
        bfs_visit = new boolean[N+1];

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
            map[x][y] = 1;
        }
        // dfs 돈다.
        dfs(V);
        // dfs_list 출력
        StringBuilder sb1 = new StringBuilder();
        for(int a : dfs_list) {
            sb1.append(a).append(" ");
        }
        System.out.print(sb1.toString().stripTrailing());
        // bfs 돈다.
        bfs(V);
        System.out.println();
        // bfs_list 출력
        sb1 = new StringBuilder();
        for(int a : bfs_list) {
            sb1.append(a).append(" ");
        }
        System.out.print(sb1.toString().stripTrailing());
    }

    private static void dfs(int node) {
        // 리스트 사이즈가 N 됐으면 리턴
        if(dfs_list.size() >= N) return;
        // 방문 체크
        dfs_visit[node] = true;
        // 리스트에 현재 값 추가
        dfs_list.add(node);
        // node 행을 순회
        for(int i=1; i<=N; i++) {
            // 1이고 아직 방문안했으면 dfs
            if(map[node][i] == 1 && !dfs_visit[i])
                dfs(i);
        }
    }

    private static void bfs(int node) {
        // 큐에 node 담기
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        bfs_visit[node] = true;
        // 큐 빌때까지 반복
        while(!q.isEmpty()) {
            // 리스트 사이즈가 노드 크기 됐으면 끝
            if(bfs_list.size() >= N) return;
            // 큐에서 노드 빼기
            int n = q.poll();
            // 방문 체크
            // 리스트에 담기
            bfs_list.add(n);
            // 노드 행 순회
            for(int i = 1; i<=N; i++) {
                // 1이고 방문안했으면 큐에담기
                if(map[n][i] == 1 && !bfs_visit[i]) {
                    q.offer(i);
                    bfs_visit[i] = true;
                }
            }
        }
        // 반복 끝
    }
}
