package com.exercise.ps.Programmers.kakao;

import java.util.*;

public class KaKaoWinterInternship_2 {
    public int[] solution(int[][] edges) {
        // edges 순회하며 이차원 정수 배열에 1로 담는다. -> 사용한 것은 2로 변경
        // 각 정점별로 나가는 간선, 들어오는 갯수 저장 (맵에)
//        boolean[][] visit = new boolean[1000001][1000001];
        Set<String> visit = new HashSet<>();
        Map<Integer, List<Integer>> linkMap = new HashMap<>();
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> list = linkMap.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            linkMap.put(edge[0], list);

            int[] info = map.getOrDefault(edge[0], new int[2]);
            info[0] += 1;
            map.put(edge[0], info);

            int[] info2 = map.getOrDefault(edge[1], new int[2]);
            info2[1] += 1;
            map.put(edge[1], info2);
        }
        // 맵 순회 -> 들어오는 갯수 0이면서, 나가는 간선이 2이상이면 시작 정점이다.
        int startNode = 0;
        for(int node : map.keySet()) {
            int[] info = map.get(node);
            if(info[1] == 0 && info[0] >= 2) {
                startNode = node;
                break;
            }
        }
        // linkMap 순회
        int steadyCnt = 0;
        int donutCnt = 0;
        int eightCnt = 0;

        // startNode의 연결점들을 순회 (각 그래프 시작점)
        outer: for(int start : linkMap.get(startNode)) {
            Queue<Integer> searchQ = new ArrayDeque<>();
            searchQ.add(start);

            int maxSize = 0;
            int maxIdx = 0;
            int current = 0;
            while (!searchQ.isEmpty()) {
                current = searchQ.poll();
//                System.out.println("node = " + current);

                List<Integer> list = linkMap.getOrDefault(current, null);
                if(list == null || list.isEmpty()) {
                    steadyCnt++;
                    continue outer;
                }

                if(list.size() > maxSize) {
                    maxSize = list.size();
                    maxIdx = current;
                }

                int next = list.get(0);
                if(!visit.contains(current + " " + next)) {
                    visit.add(current + " " + next);
                    searchQ.add(next);
                }
                else if(list.size() > 1) {
                    next = list.get(1);
                    if(!visit.contains(current + " " + next)) {
                        visit.add(current + " " + next);
                        searchQ.add(next);
                    }
                }
            }
//            System.out.println("visit.toString() = " + visit.toString());
//            System.out.println("start = " + start);
//            System.out.println("current = " + current);
//            System.out.println("maxIdx = " + maxIdx);
//            System.out.println("maxSize = " + maxSize);

            // curret : 마지막 방문노드가 첫 노드와 동일하다면
            if(current == start) {
                // maxSize가 1보다 클 경우 8자가 가능하므로, maxIdx의 2번째 노드를 기준으로 재 탐색한다. 재탐색 필요 굳이 X
                if(maxSize > 1) {
                    // - 이번에도 도넛이면 8자 카운트
                    eightCnt++;
                }
                // maxSize가 1일 경우 도넛 카운트
                else {
                    donutCnt++;
                }
            }
//            // 마지막 방문노드가 첫 노드와 다르면 막대 카운트
//            else {
//                steadyCnt++;
//            }
        }
        // 순회 끝
        // 카운트한 수 조합해서 반환
        return new int[]{startNode, donutCnt, steadyCnt, eightCnt};
    }
}
