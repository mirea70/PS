package com.exercise.ps.Programmers.code_challenge;

import java.util.ArrayList;
import java.util.List;

public class CodeChallenge_pre_1_lv2_1 {
    public int solution(String[] storage, String[] requests) {
        // 물류 창고 정보 저장
        int n = storage.length;
        int m = storage[0].length();
        char[][] map = new char[n][m];
        for(int i=0; i< n; i++) {
            map[i] = storage[i].toCharArray();
        }
        // requests에 따라 지게차 or 크레인으로 요청 컨테이너 꺼내기 : 꺼낸 자리는 -
        for(String request : requests) {
            command(map, request, n, m);
        }
        // 모두 수행 완료 후, 남은 컨테이너 수 리턴
        int cnt = 0;
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(map[r][c] != '-') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 요청 수행
    private void command(char[][] map, String request, int n, int m) {
        int len = request.length();
        char val = request.charAt(0);
        if(len == 1) {
            takeOutByGigue(map, val, n, m);
        }
        else {
            takeOutByCrain(map, val, n, m);
        }
    }

    // 지게차로 컨테이너 꺼내기
    private void takeOutByGigue(char[][] map, char request, int n, int m) {
        List<int[]> list = new ArrayList<>();
        // map을 이중 순회
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                // request와 일치할 때
                if(map[r][c] == request) {
                    if(chkOpen(map, r, c, n, m, new boolean[n][m])) {
                        list.add(new int[]{r,c});
                    }
                }
            }
        }
        // 리스트에 담긴 인덱스를 -로 바꾼다.
        for(int[] item : list) {
            map[item[0]][item[1]] = '-';
        }
    }

    private boolean chkOpen(char[][] map, int y, int x, int n, int m, boolean[][] visit) {
        if(y >= n || y < 0 || x >= m || x < 0) return true;
        if(visit[y][x]) return false;
        visit[y][x] = true;

        for(int i=0; i<4; i++) {
            // 4면 중 적어도 1면이 - 이면서
            int ny = y + Dir.ny[i];
            int nx = x + Dir.nx[i];
            // 검증할 좌표가 벽 범위 벗어날 경우 -> 그냥 바로 true
            if(ny >= n || ny < 0 || nx >= m || nx < 0) return true;
            // 이중으로 오픈되었을 때만 true
            if(map[ny][nx] == '-') {
                if(chkOpen(map, ny, nx, n, m, visit)) {
                    return true;
                }
            }
        }
        return false;
    }
    // 크레인으로 요청 컨테이너 꺼내기
    private void takeOutByCrain(char[][] map, char request, int n, int m) {
        // map을 이중순회 하며 request와 일치하면 컨테이너 꺼내기
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(map[r][c] == request) {
                    map[r][c] = '-';
                }
            }
        }
    }
}

class Dir {
    static int[] ny = new int[]{0,1,0,-1};
    static int[] nx = new int[]{1,0,-1,0};
}
