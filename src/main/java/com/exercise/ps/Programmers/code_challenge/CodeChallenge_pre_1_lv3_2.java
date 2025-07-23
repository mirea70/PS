package com.exercise.ps.Programmers.code_challenge;
import java.util.*;

public class CodeChallenge_pre_1_lv3_2 {
    public int[] solution(int[] nodes, int[][] edges) {
        // 1. 연결 정보 생성
        Map<Integer, List<Integer>> linkInfo = getLinkList(edges);
        // 2. 노드, 연결정보를 통해 트리 분류
        List<Set<Integer>> treeList = divideToTrees(nodes, linkInfo);
        // 2. 트리를 순회하며 각 트리마다 tree의 루트 노드를 설정해 순회 가능한 트리를 만든다.
        int cnt = 0;
        int rCnt = 0;

        for(Set<Integer> treeSet : treeList) {
//            System.out.println("treeSet.toString() = " + treeSet.toString());
            boolean std = false, nonStd = false;

            for (int v : treeSet) {
                CustomNode root = new CustomNode(v);
                buildTree(root, linkInfo, new HashSet<>());
                if (isStandardTree(root)) {
                    std = true;
                    break;
                }
            }

            if (!std) {
                for (int v : treeSet) {
                    CustomNode root = new CustomNode(v);
                    buildTree(root, linkInfo, new HashSet<>());
                    if (isNonStandardTree(root)) {
                        nonStd = true;
                        break;
                    }
                }
            }

            if (std) cnt++;
            else if (nonStd) rCnt++;
        }
        // 카운트한 데이터 반환
        return new int[]{cnt, rCnt};
    }

    private boolean isStandardTree(CustomNode root) {
        Queue<CustomNode> q = new ArrayDeque<>();
        q.add(root);

//        System.out.println("check start standard");
        while(!q.isEmpty()) {
            CustomNode node = q.poll();
//            System.out.println("node.val = " + node.val);
//            System.out.println("node.children.size() = " + node.children.size());
            if(node.children != null && node.children.size() != 0) {
//                System.out.println("node.children.toString() = " + node.children.toString());
            }
            if(node.val % 2 != node.children.size() % 2) return false;
            for(CustomNode child : node.children) {
                q.add(child);
            }
        }
        return true;
    }

    private boolean isNonStandardTree(CustomNode root) {
        Queue<CustomNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            CustomNode node = q.poll();
            if(node.val % 2 == node.children.size() % 2) return false;

            for(CustomNode child : node.children) {
                q.add(child);
            }
        }
        return true;
    }


    // 노드 별, 연결리스트 만들기
    public Map<Integer, List<Integer>> getLinkList(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        // edges 순회
        for(int[] edge : edges) {
            // 0번 -> 1번, 1번 -> 0번의 연결리스트를 추가한다. (없을 경우에만 새 리스트 생성)
            map.computeIfAbsent(edge[0], val -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], val -> new ArrayList<>()).add(edge[0]);
        }

        return map;
    }

    private List<Set<Integer>> divideToTrees(int[] nodes, Map<Integer, List<Integer>> linkInfo) {
        List<Set<Integer>> treeSetList = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        // 노드들을 순회
        for(int node : nodes) {
            if(visit.contains(node)) continue;
            // 아직 방문하기 전 노드이면 새 트리셋을 생성하고 linkInfo를 통해 dfs를 돌려 트리를 채운다.
            Set<Integer> treeSet = new HashSet<>();
            link(node, linkInfo, treeSet, visit);
            // 트리를 채운 후, 리스트에 트리셋을 추가한다.
            treeSetList.add(treeSet);
        }

        return treeSetList;
    }

    private void link(int node, Map<Integer, List<Integer>> linkInfo, Set<Integer> treeSet, Set<Integer> visit) {
        // 이미 방문한 노드이면 패스
        if(visit.contains(node)) return;
        // 현재 노드를 treeSet에 추가한다.
        treeSet.add(node);
        // 방문노드에도 추가한다.
        visit.add(node);
        // 연결 정보에 등록된 인접 노드들에도 재귀
        List<Integer> children = linkInfo.get(node);
        if(children == null || children.size() == 0) return;

        for(int linkNode : linkInfo.get(node)) {
            link(linkNode, linkInfo, treeSet, visit);
        }
    }

    private void buildTree(CustomNode node, Map<Integer, List<Integer>> linkInfo, Set<Integer> visit) {
        if(visit.contains(node.val)) return;
        visit.add(node.val);

        List<Integer> children = linkInfo.get(node.val);
        if(children == null || children.size() == 0) return;
        for(int linkNode : children) {
            // 이미 방문한 노드라면 패스
            if(visit.contains(linkNode)) continue;
            // 연결 정보에서 인접 노드들을 불러와 자식으로 추가한다.
            CustomNode child = new CustomNode(linkNode);
            // 각 인접노드들에 대해 dfs 돈다.
            buildTree(child, linkInfo, visit);
            node.children.add(child);
        }
    }

    // 7, 9 11
    //
}

class CustomNode {
    int val;
    List<CustomNode> children;

    public CustomNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    public String toString() {
        return String.valueOf(val);
    }
}
