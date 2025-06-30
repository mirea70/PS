package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q17135 {
    static int N;
    static int M;
    static int D;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        // 궁수의 위치를 뽑는다.
        // 뽑은 궁수 위치를 반영해서 게임을 돌린다.
        combination(0, 0, new int[3], new boolean[M]);
        // 적 최대 제거 수를 출력한다.
        System.out.print(max);
    }

    // 궁수 위치 뽑기
    private static void combination(int start, int depth, int[] current, boolean[] visit) {
        // 3명 뽑았으면 맵에 반영하고 게임 돌리기
        if(depth == 3) {
            int[][] copiedMap = new int[N][M];
            for (int r=0; r<N; r++) {
                copiedMap[r] = map[r].clone();
            }
            game(current, copiedMap);
            return;
        }

        for(int i=start; i<M; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = i;
                combination(i+1, depth+1, current, visit);
                visit[i] = false;
            }
        }
    }

    // 게임 돌리기
    private static void game(int[] archers, int[][] copiedMap) {
//        System.out.println("Arrays.toString(archers) = " + Arrays.toString(archers));
        Set<Target> targets = new HashSet<>();
        int count = 0;
        // 맵에 적이 있는동안 반복
        while(!isEmpty(copiedMap)) {
            // 궁수 위치 순회
            for(int archer : archers) {
                // 각 궁수마다 공격 가능한 적위치 리스트에 담기
                List<int[]> list = new ArrayList<>();
                for(int r=0; r<N; r++) {
                    for(int c=0; c<M; c++) {
                        if(copiedMap[r][c] == 1 ) {
                            int distance = Math.abs(N-r) + Math.abs(archer-c);
                            if(distance <= D) {
                                list.add(new int[]{r,c, distance});
                            }
                        }
                    }
                }
                // 리스트 정렬 (거리 오름차순, x위치 오름차순)
                list.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if(a[2] != b[2]) {
                            return a[2] - b[2];
                        }
                        return a[1] - b[1];
                    }
                });
                // 공격당한 적(리스트 첫번쨰) 좌표 기록해두기
                if(!list.isEmpty()) {
                    targets.add(new Target(list.get(0)[0], list.get(0)[1]));
                }
            }
            // 순회 끝
            // 공격당한 적 맵에서 제거 (0처리)
            for(Target target : targets) {
                copiedMap[target.y][target.x] = 0;
            }
            count += targets.size();
            targets.clear();
            // 적 1칸씩 이동
            for(int r=N-1; r>=0; r--) {
                for(int c=M-1; c>=0; c--) {
                    if(copiedMap[r][c] == 1) {
                        if(r+1 == N) {
                            copiedMap[r][c] = 0;
                        }
                        else {
                            copiedMap[r+1][c] = 1;
                            copiedMap[r][c] = 0;
                        }
                    }
                }
            }
        }
        // 반복 끝
        max = Math.max(max, count);
    }

    private static boolean isEmpty(int[][] copiedMap) {
        for(int r=0; r<N; r++) {
            for(int c=0; c<M; c++) {
                if(copiedMap[r][c] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
}

class Target {
    int y;
    int x;

    public Target(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object target) {
        if(!(target instanceof Target)) {
            return false;
        }
        Target value = (Target) target;
        return value.y == this.y && value.x == this.x;
    }

    @Override
    public int hashCode() {
        return this.y + this.x + 100;
    }
}
