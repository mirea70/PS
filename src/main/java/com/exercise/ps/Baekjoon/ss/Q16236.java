package main.java.com.exercise.ps.Baekjoon.ss;

import java.util.*;
import java.io.*;

public class Q16236 {

    static int[][] map;
    static int N,time;

    static List<int[]> list = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = new int[]{-1,1,0,0};
    static int[] dx = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        time = 0;
        StringTokenizer st;
        int[] start = new int[2];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    start = new int[]{i, j};
                    map[i][j] = 0;
                }
            }
        }
        // dfs 돈다
        dfs(start[0], start[1], new Shark(2,0));
        // 시간 출력
        System.out.println(time);
    }

    private static void dfs(int y, int x, Shark shark) {
        // 현 위치 먹을 수 있으면 먹는다
        if(map[y][x] != 0) shark.eat(y, x);
        // 먹을 수 있는 물고기 있는지 판단 -> 리스트에 거리로 담는다
        can_eat(y, x, shark);
        // 리스트 비어있음 리턴
        if(list.size() == 0) return;
        // 리스트가 하나이면 -> 해당 물고기 위치로 이동(리스트 비우기) (dfs)
        else if(list.size() == 1) {
            int[] np = list.get(0);
            time += np[2];
            list.clear();
            dfs(np[0], np[1], shark);
        }
        // 리스트 여러개이면 -> 리스트 정렬 (1. 거리 오름차순, 2. y값 오름차순, 3. x값 오름차순)
        // 0번째로 이동 (리스트 비우기)
        else {
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o2[2] == o1[2]) {
                        if(o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        }
                        return o1[0] - o2[0];
                    }
                    return o1[2] - o2[2];
                }
            });
            int[] np = list.get(0);
            list.clear();
            time += np[2];
            dfs(np[0], np[1], shark);
        }
    }

    private static void can_eat(int cy, int cx, Shark shark) {
        // 맵을 순회
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                // size보다 작은 물고기 찾으면
                if(map[i][j] != 0 && map[i][j] < shark.size) {
                    // 갈수있으면
                    // 리스트에 담는다
                    int dis = check(cy, cx, new Shark(shark.size, shark.eat_cnt), i, j);
                    if(dis != -1) {
                        list.add(new int[]{i,j,dis});
                    }
                }
            }
        }
        // 맵 순회 끝
    }

    // 3 2 -> 1 3

    private static int check(int cy, int cx, Shark copy_shark, int ty, int tx) {
        int[][] copy_map = new int[N+1][N+1];
        boolean[][] visit = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++) {
            copy_map[i] = map[i].clone();
        }

        q.add(new int[]{cy, cx});
        visit[cy][cx] = true;
        copy_map[cy][cx] = 0;
        // 갈수 있는 모든 경우
        // bfs 탐색
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(ny < 1 || ny > N || nx <1 || nx > N) continue;
                if(copy_map[ny][nx] > copy_shark.size) continue;
                if(visit[ny][nx]) continue;
                copy_map[ny][nx] = copy_map[now[0]][now[1]] + 1;
                if(ny == ty && nx == tx) {
                    q.clear();
                    return copy_map[ny][nx];
                }
                q.add(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
        return -1;
    }

    private static class Shark {
        int size;
        int eat_cnt;

        public Shark(int size, int eat_cnt) {
            this.size = size;
            this.eat_cnt = eat_cnt;
        }

        private void eat(int y, int x) {
            map[y][x] = 0;
            eat_cnt++;
            if(eat_cnt == size) {
                size++;
                eat_cnt = 0;
            }
        }
    }
}
