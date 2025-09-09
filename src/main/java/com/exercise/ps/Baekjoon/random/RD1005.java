package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RD1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            // 건설 비용, dp 초기화
            st = new StringTokenizer(br.readLine());
            int[] dp = new int[N + 1];
            Arrays.fill(dp, -1);
            Map<Integer, Node> map = new HashMap<>();
            for(int i = 1; i <= N; i++){
                int cost = Integer.parseInt(st.nextToken());
                map.put(i, new Node(i, cost));
            }
            // 트리정보 업데이트
            for(int  i = 1; i <= K; i++){
                st = new StringTokenizer(br.readLine());
                int childIdx = Integer.parseInt(st.nextToken());
                int parentIdx = Integer.parseInt(st.nextToken());

                Node child = map.get(childIdx);
                Node parent = map.get(parentIdx);
                parent.children.add(child);
            }

            // 주어진 타겟의 자식들을 탐색해 최소비용 구하기
            // 최소비용 출력문자에 담기
            sb.append(search(map.get(Integer.parseInt(br.readLine())), dp)).append("\n");
        }

        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    private static int search(Node node, int[] dp) {
        // 만약 dp 값이 있으면 그걸 그대로 사용한다
        if(dp[node.num] != -1) return dp[node.num];

        // 현재 필요한 시간과 자식들 필요 시간 중 최대값을 더해 리턴한다.
        int max = 0;
        for(Node child : node.children){
            max = Math.max(max, search(child, dp));
        }

        return dp[node.num] = node.cost + max;
    }

    static class Node {
        int num;
        int cost;
        List<Node> children;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
            this.children = new ArrayList<>();
        }
    }
}
