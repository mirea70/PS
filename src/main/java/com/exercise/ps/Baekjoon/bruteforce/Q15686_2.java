package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15686_2 {
    private static int min_distance = Integer.MAX_VALUE;
    private static List<int[]> chickenPositions = new ArrayList<>();
    private static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // map 저장
        map = new int[N][N];
        for(int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                int val = Integer.parseInt(st.nextToken());
                // - 2라면 리스트에 추가하고 패스
                if(val == 2) {
                    chickenPositions.add(new int[]{r,c});
                    continue;
                }
                map[r][c] = val;
            }
        }
        // 리스트 개수 중에 인덱스를 M개를 뽑기 (순서 상관 X)
        int[] idx_arr = new int[chickenPositions.size()];
        for(int i=0; i<chickenPositions.size(); i++) {
            idx_arr[i] = i;
        }
        pickListIdx(idx_arr, new boolean[idx_arr.length], new int[M], 0, 0, M);
        System.out.print(min_distance);
    }

    // 리스트 인덱스를 뽑는 조합
    private static void pickListIdx(int[] idx_arr, boolean[] visit, int[] current, int start, int depth, int cnt) {
        if(depth == cnt) {
            // 뽑아서 해당 인덱스의 좌표에 2 집어넣기 (복사 Map)
            int[][] copiedMap = new int[map.length][map[0].length];
            for(int r=0; r<copiedMap.length; r++) {
                copiedMap[r] = map[r].clone();
            }

            Queue<int[]> select_positions = new ArrayDeque<>();
            for(int i=0; i< current.length; i++) {
                int[] position = chickenPositions.get(current[i]);
                copiedMap[position[0]][position[1]] = 2;
                select_positions.add(position);
            }
            updateCityChickenDistance(copiedMap, select_positions);
            return;
        }

        for(int i=start; i<idx_arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                current[depth] = idx_arr[i];
                pickListIdx(idx_arr, visit, current, i+1, depth+1, cnt);
                visit[i] = false;
            }
        }
    }

    // 도시 치킨 거리 구하기
    private static void updateCityChickenDistance(int[][] map, Queue<int[]> select_positions) {
        int total = 0;
        // map 순회
        for(int r=0; r<map.length; r++) {
            for(int c=0; c<map[0].length; c++) {
                // 1이면 select_positions 순회하면서 각 치킨집과의 거리 구해서 그 중 최솟값 누적
                if(map[r][c] == 1) {
                    int min = Integer.MAX_VALUE;
                    for(int[] position : select_positions) {
                        min = Math.min(min, Math.abs(r- position[0]) + Math.abs(c- position[1]));
                    }
                    total += min;
                }
            }
        }
        // 순회 끝
        // 도시 치킨거리 갱신
        min_distance = Math.min(min_distance, total);
    }
}
