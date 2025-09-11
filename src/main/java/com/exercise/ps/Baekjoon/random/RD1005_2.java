package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RD1005_2 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            // dp, cost, 연결정보 map 초기화
            int[] dp = new int[N + 1];
            int[] costs = new int[N + 1];
            Map<Integer, List<Integer>> link_info = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int cost = Integer.parseInt(st.nextToken());
                costs[i] = cost;
                dp[i] = cost;
                link_info.put(i, new ArrayList<>());
            }
            // 이어진 간선 수에 따라 연결정보 저장, indegree 채우기
            int[] indegree = new int[N + 1];

            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                link_info.get(v1).add(v2);
                indegree[v2]++;
            }
            // 위상 정렬하며 dp값 갱신해나가기
            topoSort(link_info, dp, costs, indegree);
            // 정렬된 배열의 w 위치 값 반환
            int w = Integer.parseInt(br.readLine());
            System.out.println(dp[w]);
        }
    }

    // 위상 정렬 함수
    private static void topoSort(Map<Integer, List<Integer>> link_info, int[] dp, int[] costs, int[] indegree) {
        // 자신에게 이어진 간선이 0인 녀석들을 큐에 담는다
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // 큐 빌때까지 반복
        while(!q.isEmpty()) {
            // - 현재 노드 큐에서 뽑는다
            int v1 = q.poll();
            // - 뽑은 이 노드 기준으로
            // - 노드랑 연결된 다음 노드들 순회
            for(int v2 : link_info.get(v1)) {
                // -- 다음 노드 dp값 갱신 : max(기존 dp(다음노드), 기존 dp(현재노드) + 다음 노드 비용
                dp[v2] = Math.max(dp[v2], dp[v1] + costs[v2]);
                // -- 다음 노드의 indeed 감소
                indegree[v2]--;
                // -- 다음 노드 indeed가 0이면 q에 담는다.
                if(indegree[v2] == 0){
                    q.add(v2);
                }
            }
        }
    }

}
