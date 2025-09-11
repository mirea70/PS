package com.exercise.ps.Baekjoon.toposort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2252 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        Map<Integer, List<Integer>> link_info = new HashMap<>();
        for(int i = 1; i <= N; i++){
            link_info.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            indegree[v2]++;
            link_info.get(v1).add(v2);
        }

        List<Integer> sorted_students = getTopoSorted(link_info, indegree);
        StringBuilder sb = new StringBuilder();
        for(int i : sorted_students){
            sb.append(i).append(" ");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }

    private static List<Integer> getTopoSorted(Map<Integer, List<Integer>> link_info, int[] indegree) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q =  new ArrayDeque<>();
        for(int i=1;i<=N;i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int v1 = q.poll();
            result.add(v1);
            for(int v2 :  link_info.get(v1)) {
                indegree[v2]--;
                if(indegree[v2]==0) {
                    q.add(v2);
                }
            }
        }

        return result;
    }
}
