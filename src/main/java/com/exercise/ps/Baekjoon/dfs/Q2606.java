package main.java.com.exercise.ps.Baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2606 {

    static int[][] map;
    static boolean[] virus;
    static int N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        // map을 그린다
        StringTokenizer st;
        map = new int[N+1][N+1];
        virus = new boolean[N+1];

        for(int i=0; i< K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
            map[x][y] = 1;
        }
        // 1,1부터 1값 찾아서 바이러스 감염
        dfs(1);
        // cnt 출력
        System.out.println(cnt-1);
    }

    private static void dfs(int start) {
        virus[start] = true;
        cnt++;
        // 1일 경우 해당 x값이 바이러스 감염 상태 아닐 경우 감염
        for(int i=1; i<=N; i++) {
            if(map[start][i] == 1 && !virus[i]) {
                dfs(i);
            }
        }
    }
}
