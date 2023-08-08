package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15686 {

    static int N;
    static int M;
    static int[][] map;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][N+2];
        // 지도를 순회 -> 치킨집의 위치 저장하는 리스트 생성 (지도 그리며 같이 담기)
        List<int[]> chicken_positions = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) chicken_positions.add(new int[]{i,j});
            }
        }
        List<int[]> output = new ArrayList<>();
        for(int i=0; i<M; i++) {
            output.add(new int[] {-1,-1});
        }
        // 해당 리스트 중 M개 만큼 뽑는 조합 실행
        combi(chicken_positions, output, new boolean[chicken_positions.size()],0, 0, M);
        // 최솟값을 출력한다.
        System.out.println(min);
    }

    private static void combi(List<int[]> chicken_positions,List<int[]> output, boolean[] visit, int start, int depth ,int r) {

        if(depth == r) {
            // 도시 치킨거리를 구한다.
            // 도시 치킨 거리는 각 집의 치킨거리의 합이다.
            // 최솟값을 갱신한다.
            int chicken_length = getChicken_length(output);
            min = Math.min(min, chicken_length);
            return;
        }

        for(int i=start; i<chicken_positions.size(); i++) {
            if(!visit[i]) {
                visit[i] = true;
                output.set(depth, chicken_positions.get(i));
                combi(chicken_positions, output,visit,i + 1, depth + 1, r);
                visit[i] = false;
            }
        }
    }

    private static int getChicken_length(List<int[]> output) {
        // 복사 지도 생성
        int[][] copy_map = map;
        // 복사 지도를 순회하며 2를찾고, 해당 포지션이 selects에 포함되어있지 않으면 0으로 바꾼다.
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(copy_map[i][j] == 2) {
                    boolean isSelected = false;
                    for(int[] arr : output) {
                        if(arr[0] == i && arr[1] == j) isSelected = true;
                    }
                    if(!isSelected) copy_map[i][j] = 0;
                }
            }
        }
        // 복사 지도 순회 끝
        // 복사 지도를 순회하며 1을 찾으면 해당 집의 치킨거리를 구한다.
        int sum = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(copy_map[i][j] == 1) {
                    int chicken_home_length = get_chicken_home_length(output, i, j);
                    sum+= chicken_home_length;
                }
            }
        }
        // 집의 치킨 거리 합 갱신
        // 복사 지도 순회 끝
        // 집 치킨 거리 합 리턴
        return sum;
    }

    private static int get_chicken_home_length(List<int[]> selects, int y, int x) {
        int home_min = Integer.MAX_VALUE;
            for(int[] select : selects) {
                int length = Math.abs(select[0] - y) + Math.abs(select[1] - x);
                home_min = Math.min(home_min, length);
            }
        return home_min;
    }
}
