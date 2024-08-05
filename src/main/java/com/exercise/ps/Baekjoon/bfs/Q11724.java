package main.java.com.exercise.ps.Baekjoon.bfs;

import java.util.*;
import java.io.*;

public class Q11724 {

    static int N;
    static boolean[][] link;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        link = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        int cnt = 0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            link[y][x] = true;
            link[x][y] = true;
        }
        br.close();
        // 정점을 순회한다
        for(int i=1; i<=N; i++) {
            // 방문 안했으면
            if(!visit[i]) {
                // bfs를 돈다
                bfs(i);
                // 카운트
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int node) {
        // 큐에 현재 노드 넣기
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        // 큐 빌때까지 반복
        while(!q.isEmpty()) {
            int current = q.poll();
            // node, 1~ 순회6 8
            for(int i = 1; i<=N; i++) {
                // 아직 방문 X, 연결요소 찾으면 큐에 넣기
                if(!visit[i] && link[current][i]) {
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
        // 반복문 끝
    }
}
