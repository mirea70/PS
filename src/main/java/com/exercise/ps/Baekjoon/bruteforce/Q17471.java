package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q17471 {
    static int min_dif = Integer.MAX_VALUE;
    static boolean[][] link_info;
    static int[] div_people;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        div_people = new int[N+1];
        for(int i=1; i<=N; i++) {
            div_people[i] = Integer.parseInt(st.nextToken());
        }

        link_info = new boolean[N+1][N+1];
        for(int r=1; r<=N; r++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for(int c=1; c<=cnt; c++) {
                link_info[r][Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 1개를 뽑는 조합 ~ N-1개를 뽑는 조합 순회
        for(int i=1; i<N; i++) {
            combination(new boolean[N+1], 1, 0, i);
        }
        // 순회 끝
        // 차이 최소값 출력
        System.out.print(min_dif == Integer.MAX_VALUE ? -1 : min_dif);
    }

    // 조합 구하기
    private static void combination(boolean[] visit, int start, int depth, int r) {
        // 조합 완성될 때마다, 해당 조합으로 구역 나누기 가능한지 체크
        if(depth == r) {
            Set<Integer> divSet1 = new HashSet<>();
            int startIdx1 = -1;
            int startIdx2 = -1;

            Set<Integer> divSet2 = new HashSet<>();
            for(int i=1; i< visit.length; i++) {
                if(visit[i]) {
                    divSet1.add(i);
                    startIdx1 = i;
                }
                else {
                    divSet2.add(i);
                    startIdx2 = i;
                }
            }
            // 구역 나누기 가능하다면, 구역별 인원 수 자료에서 두 조합의 각각 합을 구한 뒤, 차이 갱신
            if(isValid(startIdx1, divSet1, new boolean[N+1])
                    && (isValid(startIdx2, divSet2, new boolean[N+1]))) {
                int sum1 = 0;
                for(int div : divSet1) {
                    sum1 += div_people[div];
                }
                int sum2 = 0;
                for(int div : divSet2) {
                    sum2 += div_people[div];
                }

                min_dif = Math.min(min_dif, Math.abs(sum1 - sum2));
            }
            return;
        }

        for(int i=start; i<visit.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                combination(visit, i+1, depth+1, r);
                visit[i] = false;
            }
        }
    }

    // 구역 나누기 체크
    private static boolean isValid(int index, Set<Integer> divSet, boolean[] visit) {
        // 현재 index에 연결되어있으면서, 아직 방문하지 않은 구역 재귀
        visit[index] = true;
        for(int div : divSet) {
            if(link_info[index][div] && !visit[div]) {
                if(isValid(div, divSet, visit)) {
                    return true;
                }
            }
        }
        int visit_cnt = 0;
        for(boolean b : visit) {
            if(b) visit_cnt++;
        }
        return visit_cnt == divSet.size();
    }
}
