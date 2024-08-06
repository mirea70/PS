package main.java.com.exercise.ps.Baekjoon.ip;

import java.util.*;
import java.io.*;

public class Q16234 {

    static boolean is_move = false;

    static int[][] map;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static int N,L,R;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        // 인구 이동 시작 (반복)
        while(true) {
            // 1,1 부터 맵 순회
            List<Gather> gathers = new ArrayList<>();
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    Gather gather = new Gather();
                    // 방문x이면 dfs
                    if(!visit[i][j]) {
                        dfs(i,j, gather);
                    }
                   gathers.add(gather);
                }
                // 순회 끝
            }
            // is_move : false이면 반복문 종료
            if(!is_move) break;
            // gathers 순회
            // gather의 나라들 길이가 1 초과이면 각 나라들의 map값을 계산해 초기화
           for(Gather g : gathers) {
               if(g.countries.size() > 1) {

                   int value = g.sum / g.depth;

                   for(int[] target : g.countries) {
                       map[target[0]][target[1]] = value;
                   }
               }
           }

            // 방문체크 초기화, 카운트 증가, is_move = false
            visit = new boolean[N+1][N+1];
            cnt++;
            is_move = false;
            // 인구 이동 끝
        }
        // 카운트 출력
        System.out.println(cnt);
    }

    private static void dfs(int y, int x, Gather gather) {
        // 방문 체크
        visit[y][x] = true;
        gather.countries.add(new int[]{y,x});
        gather.addDepth();
        gather.addSum(map[y][x]);
        // 상하좌우 이동
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // 벽 or 방문 예외
            if(ny < 1 || ny > N || nx < 1 || nx > N || visit[ny][nx]) continue;
            // 차이가 L이상 R이하이면 dfs -> map값 넣기, is_move = true
            int dif = Math.abs(map[ny][nx] - map[y][x]);
            if(dif >= L && dif <= R) {
                is_move = true;
                dfs(ny,nx,gather);
            }
        }
    }

    private static class Gather {
        // 좌표 리스트
        List<int[]> countries;
        // 깊이
        int depth;
        // 합계
        int sum;

        public Gather() {
            countries = new ArrayList<>();
            depth = 0;
            sum = 0;
        }

        public void addDepth() {
            depth++;
        }

        public void addSum(int value) {
            sum += value;
        }
    }
}
