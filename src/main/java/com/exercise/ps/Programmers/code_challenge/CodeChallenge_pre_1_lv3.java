package com.exercise.ps.Programmers.code_challenge;

import java.util.*;

public class CodeChallenge_pre_1_lv3 {
    public int[] solution(int[] nodes, int[][] edges) {
        // 1. nodes, edges 정보를 통해 트리를 분류
        List<CustomTree> treeList = getTrees(nodes, edges);
        System.out.println("treeList.size() = " + treeList.size());
        // 2. 각 트리 순회
        int cnt = 0;
        int rCnt = 0;

        for(CustomTree tree : treeList) {
//            System.out.println("tree : " + tree.rootVal);
//            tree.print(tree.nodes.get(tree.rootVal));
//            System.out.println("tree");
            // - 트리 별로 루트 노드 변경해서 홀짝 트리 / 역홀짝 트리 가능 검증
            for(int key : tree.nodes.keySet()) {
                tree.updateRoot(key);
                // - 가능하다면 카운트하고 다음 트리로 넘기기
                if(isStandard(tree)) {
                    cnt++;
                    break;
                }
                else if(isNonStandard(tree)) {
                    rCnt++;
                    break;
                }
            }
        }
        // 순회 끝
        // 카운트한 개수 배열로 담아 리턴
        return new int[]{cnt, rCnt};
    }

    // 트리 분류 함수
    private List<CustomTree> getTrees(int[] nodes, int[][] edges) {
        List<CustomTree> treeList = new ArrayList<>();
        boolean[] selected = new boolean[edges.length];
        Set<Integer> used = new HashSet<>();
        // edges 순회
        outer: for(int i=0; i<edges.length; i++) {
            // 이미 선택되었다면 패스
            if(selected[i]) continue;
            // 선택
            selected[i] = true;
            // 리스트에 현재 배열 값 추가, 타겟으로 선정
            int[] current = edges[i];
            int target1 = current[0];
            int target2 = current[1];
            // 만약 두 값 중 하나가 이미 추가된 상태라면 노드 자식으로 추가 후 패스
            for(CustomTree t : treeList) {
                if(t.contains(target1)) {
//                    System.out.println("after Add");
//                    System.out.println("target1 = " + target1);
//                    System.out.println("target2 = " + target2);
                    t.add(target2, target1);
                    used.add(target2);
                    continue outer;
                }
                else if(t.contains(target2)) {
//                    System.out.println("after Add");
//                    System.out.println("target2 = " + target2);
//                    System.out.println("target1 = " + target1);
                    t.add(target1, target2);
                    used.add(target1);
                    continue outer;
                }
            }

            used.add(target1);
            used.add(target2);

            CustomTree tree = new CustomTree(new TreeNode(target1, null));

            tree.add(target2, target1);
            // edges 내부 순회
            for(int j=i+1; j<edges.length; j++) {
                // 이미 선택되었다면 패스
                if(selected[j]) continue;
                // 트리 값들 중 하나가 포함되어 있으면, 트리로 추가
                int val1 = edges[j][0];
                int val2 = edges[j][1];
                if(tree.contains(val1)) {
                    selected[j] = true;
                    tree.add(val2, val1);
                    used.add(val1);
                    used.add(val2);
                }
                else if(tree.contains(val2)) {
                    selected[j] = true;
                    tree.add(val1, val2);
                    used.add(val1);
                    used.add(val2);
                }
            }
            treeList.add(tree);
        }

        // nodes 순회해서 아직도 사용안된게 있으면 tree에 그냥 추가
        for(int node : nodes) {
            if(!used.contains(node)) {
                CustomTree tree = new CustomTree(new TreeNode(node, null));
                treeList.add(tree);
            }
        }

        return treeList;
    }

    // 홀짝 트리 검증
    private boolean isStandard(CustomTree tree) {
//        System.out.println("standard validation");
        TreeNode root = tree.nodes.get(tree.rootVal);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
//            System.out.println("node.val = " + node.val);
//            System.out.println("children = " + node.children.toString());
            // 노드 홀수여부, 자식개수 홀수여부 값이 서로 다를경우
            if((node.val % 2 == 0) != (node.children.size() % 2 == 0)) return false;
            // 자식 노드들 q에 담기
            for(TreeNode child : node.children) {
                q.add(child);
            }
        }

        return true;
    }
    // 역홀짝 트리 검증
    private boolean isNonStandard(CustomTree tree) {
//        System.out.println("nonStandard validation");
        TreeNode root = tree.nodes.get(tree.rootVal);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();
//            System.out.println("node.val = " + node.val);
//            System.out.println("node.children.toString() = " + node.children.toString());
            // 노드 홀수여부, 자식개수 홀수여부 값이 서로 같을 경우
            if((node.val % 2 == 0) == (node.children.size() % 2 == 0)) return false;
            // 자식 노드들 q에 담기
            for(TreeNode child : node.children) {
                q.add(child);
            }
        }

        return true;
    }
}

class CustomTree {
    Map<Integer, TreeNode> nodes;
    int rootVal;

    public CustomTree(TreeNode root) {
        nodes = new HashMap<>();
        nodes.put(root.val, root);
        rootVal = root.val;
    }

    public void add(int val, int parentVal) {
        TreeNode parent = nodes.get(parentVal);
        TreeNode current = new TreeNode(val, parent);
        parent.addChildren(current);
        nodes.put(val, current);
    }

    public boolean contains(int val) {
        return nodes.containsKey(val);
    }

    public void updateRoot(int val) {
        if(!contains(val)) return;
        if(val == rootVal) return;
        rootVal = val;
        TreeNode root = nodes.get(rootVal);
        // 부모였던 놈을 자식으로 추가
        TreeNode parent = root.parent;
        root.addChildren(parent);
        // 부모가 있었다면 자식으로 추가하기
        if(parent.parent != null) {
            parent.addChildren(parent.parent);
        }
        // 부모였던 놈의 부모로 자신 지정
        parent.parent = root;
        // 원래 부모였던 노드 자식 중 자신을 제거
        parent.children.removeIf(node -> node.val == rootVal);
        // 부모값 null
        root.parent = null;
    }
}

class TreeNode {
    int val;
    TreeNode parent;
    List<TreeNode> children;

    public TreeNode(int val, TreeNode parent) {
        this.val = val;
        this.parent = parent;
        children = new ArrayList<>();
    }

    public void addChildren(TreeNode val) {
        children.add(val);
    }

    public String toString() {
        return String.valueOf(val);
    }
}
