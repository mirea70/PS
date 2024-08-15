package com.exercise.ps.Baekjoon.a_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19237 {

    private static int[] dy = {-1,1,0,0};
    private static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 상어용 격자 그리기 준비
        int[][] tmp_map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                tmp_map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Shark[] sharks = new Shark[m+1];

//        Shark[][] map = new Shark[n][n];
        // 상어 방향 저장
        int[] shark_dirs = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            shark_dirs[i] = Integer.parseInt(st.nextToken());
        }

        // 상어 우선순위 저장하는 3차원 배열
        int[][][] move_priorities = new int[m+1][4][4];
        for(int mp=1; mp<=m; mp++) {
            for(int r=0; r<4; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c=0; c<4; c++) {
                    move_priorities[mp][r][c] = Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        // 격자 그리면서 상어 넣기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int index = tmp_map[i][j];
                if(index != 0) {
                    int[][] move_priority = move_priorities[index];
                    Shark shark = new Shark(index, shark_dirs[index-1]-1, move_priority, i, j);
                    sharks[index] = shark;
                }
            }
        }
        // 냄새용 격자 공간 생성
        Smell[][] smell_map = new Smell[n][n];
        // 시간 변수
        int time = 0;
        // 상어 이동 반복 (1번 상어만 남게될 때까지)
        while(!isOnlyOne(sharks)) {
            if(time >= 1000) break;
            // 냄새 카운트 감소
            disCountSmell(smell_map, n);
            // 시간 증가
            time++;
            // 냄새 뿌리기
            for(Shark shark : sharks) {
                if(shark == null) continue;
                int y = shark.y;
                int x = shark.x;
                smell_map[y][x] = new Smell(shark.num, k);
            }
            // 상어의 우선순위에 따라 이동 시도
            for(int sh = 0; sh<sharks.length; sh++) {
                Shark shark = sharks[sh];
                if(shark == null) continue;
                int y = shark.y;
                int x = shark.x;

                int dir = shark.dir;
                int[][] move_priority = shark.move_priority;
                boolean is_moved = false;
                int my_y = -1;
                int my_x = -1;
                int my_dir = -1;

                for(int l=0; l<4; l++) {
                    int n_dir = move_priority[dir][l];
                    int ny = y + dy[n_dir];
                    int nx = x + dx[n_dir];
                    // - 벽이면 패스
                    if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                    // - 냄새가 이미 있으면
                    if(smell_map[ny][nx] != null) {
                        // -- 자신의 냄새일 경우 저장
                        if(smell_map[ny][nx].sharkNum == shark.num && my_y == -1 && my_x == -1) {
                            my_y = ny;
                            my_x = nx;
                            my_dir = n_dir;
                        }
                        // -- 패스
                        continue;
                    }
                    // - 상어가 이미 있을 경우
                    int org_idx = tmp_map[ny][nx];
                    if(org_idx != 0) {
                        // 원래 상어가 더 크면 넣을 상어는 내쫒기
                        if(org_idx < shark.num) {
                            sharks[shark.num] = null;
                            tmp_map[y][x] = 0;
                            is_moved = true;
                            break;
                        }
                        // 기존 상어가 더 크다면 원래 상어 내쫒기
                        else {
                            sharks[org_idx] = null;
                        }
                    }
                    // 이동
                    is_moved = true;
                    shark.dir = n_dir;
                    shark.y = ny;
                    shark.x = nx;
                    tmp_map[ny][nx] = shark.num;
                    tmp_map[y][x] = 0;
                    break;
                }
                // 이동 시도 완료 후, 아직 이동 못했을 경우 자신의 냄새의 좌표가 있을 경우 주변에 그곳으로 이동
                if(!is_moved) {
                    // - 상어가 이미 있을 경우
                    int org_idx = tmp_map[my_y][my_x];
                    if(org_idx != 0) {
                        // 원래 상어가 더 작다면 이동할 상어는 내쫒기
                        if(org_idx < shark.num) {
                            sharks[shark.num] = null;
                            tmp_map[y][x] = 0;
                            break;
                        }
                        //  이동할 상어가 더 작다면 원래 상어 내쫒기
                        else {
                            for(Shark oShark : sharks) {
                                if(oShark.num == org_idx) {
                                    sharks[org_idx] = null;
                                    break;
                                }
                            }
                        }
                    }
                    shark.dir = my_dir;
                    shark.y = my_y;
                    shark.x = my_x;
                    tmp_map[my_y][my_x] = shark.num;
                    tmp_map[y][x] = 0;
                }
            }

        }

        // 시간이 1001초 이상이라면 -1로 변경
        if(time >= 1000) time = -1;
        System.out.print(time);
    }
    // 현재 지도에서 1번 상어만 존재하는지 아닌지 판단하는 함수
    private static boolean isOnlyOne(Shark[] sharks) {
        for(Shark shark : sharks) {
            if(shark != null && shark.num != 1) return false;
        }
        return true;
    }
    // 냄새 카운트 감소
    private static void disCountSmell(Smell[][] smell_map, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                Smell smell = smell_map[i][j];
                if(smell != null) {
                    // 카운트가 1 남았으면 그냥 null
                    if(smell.count == 1) smell_map[i][j] = null;
                    // 아니면 1감소
                    else smell.count--;
                }
            }
        }
    }
}

class Shark {
    int num;
    int dir;
    int[][] move_priority;
    int y;
    int x;

    public Shark (int num, int dir, int[][] move_priority, int y, int x) {
        this.num = num;
        this.dir = dir;
        this.move_priority = move_priority;
        this.y = y;
        this.x = x;
    }

}

class Smell {
    int sharkNum;
    int count;

    public Smell (int sharkNum, int count) {
        this.sharkNum = sharkNum;
        this.count = count;
    }
}