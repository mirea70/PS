package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q17472 {
    static int N;
    static int M;
    static int[][] map;
    static List<Area> areaList = new ArrayList<>();
    // 우하좌상
    static int[] dy = new int[]{0,1,0,-1};
    static int[] dx = new int[]{1,0,-1,0};
    static int min_bridge_cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 지도 저장
        map = new int[N][M];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 각 섬을 저장
        saveAreas();
        // 각 섬들을 서로 연결할 지 말지를 결정하는 뽑기
        int area_cnt = areaList.size();
//        System.out.println("area_cnt = " + area_cnt);
        boolean[][] link_info = new boolean[area_cnt][area_cnt];
        link_pick(link_info, 0, area_cnt);
        System.out.print(min_bridge_cnt == Integer.MAX_VALUE ? -1 : min_bridge_cnt);
    }

    private static void link_pick(boolean[][] link_info, int area_idx, int area_cnt) {
        // 각 뽑기마다 연결 시도
        if(area_idx == area_cnt) {
            link(link_info, area_cnt);
            return;
        }

        // 각 섬과 연결할지 말지
        for(int i=0; i<area_cnt; i++) {
            if(area_idx == i || link_info[area_idx][i]) continue;
            link_info[area_idx][i] = true;
            link_info[i][area_idx] = true;
            link_pick(link_info, area_idx+1, area_cnt);
            link_info[area_idx][i] = false;
            link_info[i][area_idx] = false;
            link_pick(link_info, area_idx+1, area_cnt);
        }
    }

    private static void link(boolean[][] link_info, int area_cnt) {
        boolean[][] visited = new boolean[area_cnt][area_cnt];
        int bridge_cnt = 0;
        // link_info 순회하며 아직 방문은 안했지만 true일 경우
        for(int r=0; r<area_cnt; r++) {
            for(int c=0; c<area_cnt; c++) {
                if(!visited[r][c] && link_info[r][c]) {
                    visited[r][c] = true;
                    visited[c][r] = true;
                    int cur_bridge_cnt = 12;

                    Area a = areaList.get(r);
                    Area b = areaList.get(c);
                    // 연결
                    for(int ai=0; ai<a.y_list.size(); ai++) {
                        for(int bi=0; bi<b.y_list.size(); bi++) {
                            // 유효한 다리이면 그 때의 다리 개수 (최소 갱신)
                            int valid_result = isBridge(a.y_list.get(ai), a.x_list.get(ai), b.y_list.get(bi), b.x_list.get(bi));
                            if(valid_result != -1) {
                                cur_bridge_cnt = Math.min(cur_bridge_cnt, valid_result);
                            }
                        }
                    }

                    // 만약 연결 실패하는 섬이 하나라도 존재할 경우 전체 연결 종료
                    if(cur_bridge_cnt == 12) {
                        return;
                    }

                    bridge_cnt += cur_bridge_cnt;
                }
            }
        }
        // 모든 섬 연결했으면 모든 섬 연결 가능 여부에 따라 다리 최소 개수 갱신
        if(checkAllLink(link_info)) {
            min_bridge_cnt = Math.min(min_bridge_cnt, bridge_cnt);
        }
    }

    private static int isBridge(int y1, int x1, int y2, int x2) {
        if (y1 == y2) {
            int from = Math.min(x1, x2);
            int to = Math.max(x1, x2);
            int val = Math.abs(to - from) - 1;
            if(val < 2) return -1;
            for(int x= from+1; x < to; x++) {
                if (map[y1][x] != 0) return -1;
            }
            return val;
        }
        else if(x1 == x2) {
            int from = Math.min(y1, y2);
            int to = Math.max(y1, y2);
            int val = Math.abs(to - from) - 1;
            if(val < 2) return -1;
            for(int y= from+1; y < to; y++) {
                if (map[y][x1] != 0) return -1;
            }
            return val;
        }
        return -1;
    }

    private static boolean checkAllLink(boolean[][] link_info) {
        int size = link_info.length;
        boolean[] visited = new boolean[size];
        // 0번 부터 시작
        tryAllLink(link_info, 0, visited);
        // 모두 방문했으면 true 반환
        for(int i=0; i<size; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private static void tryAllLink(boolean[][] link_info, int index, boolean[] visited) {
        visited[index] = true;
        for(int i=0; i<link_info.length; i++) {
            if(!visited[i] && link_info[index][i]) {
                tryAllLink(link_info, i, visited);
            }
        }
    }

    private static void saveAreas() {
        boolean[][] visited = new boolean[N][M];
        // 지도 순회
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                // 1만났는데, 아직 방문 전이면 섬 영역 생성해서 추가
                if(!visited[r][c] && map[r][c] == 1) {
                    Area area = new Area();
                    createArea(visited, r, c, area);
                    if(!area.isEmpty()) areaList.add(area);
                }
            }
        }
    }

    private static void createArea(boolean[][] visited, int y, int x, Area area) {
        visited[y][x] = true;
        area.add(y, x);

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= N || ny < 0 || nx >= M || nx < 0) continue;
            if(visited[ny][nx]) continue;
            if(map[ny][nx] == 1) {
                createArea(visited, ny, nx, area);
            }
        }
    }
}

class Area {
    List<Integer> y_list;
    List<Integer> x_list;

    public Area() {
        y_list = new ArrayList<>();
        x_list = new ArrayList<>();
    }

    public void add(int y, int x) {
        y_list.add(y);
        x_list.add(x);
    }

    public boolean isEmpty() {
        return y_list.isEmpty() && x_list.isEmpty();
    }
}
