package com.exercise.ps.Baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q14889 {

    private static int[][] table;
    private static int min_dif = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        table = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //  N개 중 N/2개를 뽑는 조합 실행
        pick(N, new int[N/2], new boolean[N], 0, 0);
        // 차이 최소값 출력
        System.out.print(min_dif);
    }

    // N/2만큼 뽑는 조합
    private static void pick(int N, int[] current, boolean[] visited, int depth, int start) {
        // depth == N/2이면
        if(depth == N/2) {
//            System.out.println("start : " + Arrays.toString(current));
            // 리스트에 1~N 저장
            List<Integer> list = new ArrayList<>();
            for(int i=1; i<=N; i++)
                list.add(i);
            // current 순회 - 리스트에서 해당 값 삭제
            for(int i=0; i<current.length; i++) {
                list.remove(Integer.valueOf(current[i]));
            }
//            System.out.println("list : " + list.toString());
            // 각각 팀 능력치 계산 -> 차이 갱신
            int startScore = calculateTeamScore(current);
            int linkScore = calculateTeamScore(list.stream().mapToInt(i->i).toArray());
            min_dif = Math.min(min_dif, Math.abs(startScore-linkScore));
            return;
        }

        for(int i=start; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                current[depth] = i+1;
                pick(N, current, visited, depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    // 능력치 계산
    private static int calculateTeamScore(int[] members) {
        int sum = 0;
        // 주어진 멤버들 중 2개 숫자씩 뽑는다. (이중순회)
        for(int i=0; i<members.length; i++) {
            for(int j=0; j<members.length; j++) {
                if(i == j) continue;
                // 주어진 테이블에서 뽑은 숫자 i, j + j+i를 구한뒤 누적
                sum+= table[members[i]-1][members[j]-1] + table[members[j]-1][members[i]-1];
            }
        }
        // 누적값 리턴
        return sum/2;
    }
}
