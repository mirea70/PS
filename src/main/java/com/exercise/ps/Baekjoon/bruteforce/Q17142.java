package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17142 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};
    static List<Virus> virusList = new ArrayList<>();
    static int min_time = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        // 연구소 그리면서 2위치 리스트에 저장
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                int val = Integer.parseInt(st.nextToken());
                map[r][c] = val;
                if(val == 2) {
                    virusList.add(new Virus(r, c, 0));
                }
            }
        }


        // 연구소에서 활성 바이러스 M개 뽑기 (리스트 인덱스 뽑기)
        combination(M, 0, 0, new int[M], new boolean[virusList.size()]);
        // 퍼뜨리는 최소 시간 출력
        System.out.print(min_time == Integer.MAX_VALUE ? -1 : min_time);
    }

    private static void combination(int m, int depth, int start, int[] current, boolean[] visit) {
        if(depth == m) {
            // 각 뽑기마다 지도를 복사해서 바이러스 끝까지 퍼뜨리기
            int[][] copiedMap = new int[N][N];
            // 벽은 -9, 비활성 바이러스는 -2, 빈칸은 -1로 표시
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    int val = map[r][c];
                    switch (val) {
                        case 0: copiedMap[r][c] = -1;
                        break;
                        case 1: copiedMap[r][c] = -9;
                        break;
                        case 2: copiedMap[r][c] = -2;

                    }
                }
            }
            // 뽑은 인덱스에 해당하는 바이러스 위치 큐에 담기
            Queue<Virus> queue = new ArrayDeque<>();
            for(int idx : current) {
                queue.add(virusList.get(idx));
            }
            spread(copiedMap, queue);
            return;
        }

        for(int i=start; i<virusList.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = i;
                combination(m, depth+1, i+1, current, visit);
                visit[i] = false;
            }
        }
    }

    private static void spread(int[][] copiedMap, Queue<Virus> queue) {
        int time = 0;
        boolean[][] visited = new boolean[N][N];

        while(!queue.isEmpty()) {
            // 큐에서 하나 뺀다
            Virus current = queue.poll();
            // 현재 time 값 갱신
            time = current.time;
            visited[current.y][current.x] = true;

            // 현재 위치 time 삽입
            copiedMap[current.y][current.x] = time;
            // 상하좌우 바이러스 전파시도
            for(int i=0; i<4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                // 경계선 넘을 경우 패스
                if(ny >= N || ny < 0 || nx >= N || nx < 0)
                    continue;
                // 방문한 경우 패스
                if(visited[ny][nx])
                    continue;
                // -1이면 큐에 담기
                if(copiedMap[ny][nx] == -1 || copiedMap[ny][nx] == -2) {
                    Virus virus = new Virus(ny, nx, time+1);
                    queue.add(virus);
                    visited[ny][nx] = true;
                }
            }
        }

        // 체크해서 모든 칸에 퍼뜨렸을 경우 최소 시간 갱신
        int maxTime = getMaxTime(copiedMap);
        if(maxTime != -1) {
            min_time = Math.min(min_time, maxTime);
        }
    }

    private static int getMaxTime(int[][] copiedMap) {
        int time = 0;
        // 여전히 빈칸인 것이 하나라도 존재하면 false
        for(int r=0; r<N; r++) {
            for(int c=0; c<N; c++) {
                if(map[r][c] == 0) {
                    if(copiedMap[r][c] == -1) {
                        return -1;
                    }
                    time = Math.max(time, copiedMap[r][c]);
                }
            }
        }

        return time;
    }
}

class Virus {
    int y;
    int x;
    int time;

    public Virus(int y, int x, int time) {
        this.y = y;
        this.x = x;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Virus)) return false;
        Virus virus = (Virus) o;
        return virus.y == y && virus.x == x;
    }

    @Override
    public int hashCode() {
        return y+x+100+x+y;
    }
}
