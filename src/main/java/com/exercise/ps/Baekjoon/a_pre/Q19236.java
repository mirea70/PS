package com.exercise.ps.Baekjoon.a_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q19236 {

    private static int max = 0;
    private static Fish[][] map;
    // 위, 왼위, 왼, 왼아래, 아래, 오른아래, 오른, 오른위
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new Fish[4][4];
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                Fish fish = new Fish(num, dir-1);
                map[i][j] = fish;
            }
        }
        Fish initFish = map[0][0];
        // 상어 초기값
        int y = 0;
        int x = 0;
        // 상어의 방향
        int shark_dir = -1;
        // 넣을 배열 복사
        Fish[][] copy_map = new Fish[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++) {
                copy_map[i][j] = map[i][j].copyFish();
            }
        }
        dfs(y, x, shark_dir, 0, copy_map);
        // max 값 출력
        System.out.print(max);
    }

    // 상어의 이동하는 경우의 수를 구하는 함수
    private static void dfs(int y, int x, int dir, int sum, Fish[][] map) {
        // 현재위치 먹기
        // -- 방향 조정
        dir = map[y][x].dir;
        // -- 물고기 번호 다음 재귀에 +
        int fish_num = map[y][x].num;
        // -- 해당위치 null
        map[y][x] = null;
        // 물고기 이동
        move_fish(map, y, x);
        // 상어 이동할 곳 정하기
        int move_len = 0;
        int ny = y + dy[dir];
        int nx = x + dx[dir];
        while(ny < 4 && ny >= 0 && nx < 4 && nx >= 0) {
            // 물고기가 없으면 패스
            if(map[ny][nx] == null) continue;
            // 현재 지도 복사
            Fish[][] copy_map = new Fish[4][4];
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++) {
                    if(map[i][j] != null)
                        copy_map[i][j] = map[i][j].copyFish();
                }
            }
            dfs(ny, nx, dir, sum + fish_num, copy_map);
            ny += dy[dir];
            nx += dx[dir];
        }
        // 이동할 곳이 없다면 현재 sum으로 max값 갱신
        max = Math.max(max, sum);
    }

    private static void move_fish(Fish[][] map, int shark_y, int shark_x) {
        // 현재 존재하는 물고기의 번호들 찾아서 오름차순 정렬
        List<int[]> num_list = new ArrayList<>();
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                if(map[i][j] != null) num_list.add(new int[]{map[i][j].num, i, j});
            }
        }
        Collections.sort(num_list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 해당 번호들 순회하며 이동 시도
        for(int i=0; i<num_list.size(); i++) {
            // 이동 유무 저장 변수
            boolean is_moved = false;
            int[] arr = num_list.get(i);
            int fy = arr[1];
            int fx = arr[2];
            Fish fish = map[fy][fx];
            int move_cnt = 0;
            while(!is_moved) {
                if(move_cnt >= 8) break;
                int ny = fy + dy[fish.dir];
                int nx = fx + dx[fish.dir];
                // - 물고기가 없거나, 상어가 있거나 경계 넘으면 방향전환
                if((ny == shark_y && nx == shark_x) || ny >= 4 || ny < 0 || nx >= 4 ||  nx < 0 || map[ny][nx] == null) {
                    move_cnt++;
                    fish.rotate();
                }
                // 그렇지 않으면 이동
                else {
                    is_moved = true;
                    Fish tmp = map[fy][fx];
                    map[fy][fx] = map[ny][nx];
                    map[ny][nx] = tmp;
                }
            }
        }
    }
}

class Fish {
    int num;
    // 위, 왼위, 왼, 왼아래, 아래, 오른아래, 오른, 오른위
    int dir;

    public Fish(int num, int dir) {
        this.num = num;
        this.dir = dir;
    }

    public void rotate() {
        this.dir = (this.dir+1) % 8;
    }

    public Fish copyFish() {
        return new Fish(this.num, this.dir);
    }
}
