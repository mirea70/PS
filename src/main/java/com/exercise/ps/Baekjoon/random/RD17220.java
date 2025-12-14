package com.exercise.ps.Baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RD17220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 관계도 입력받으며 트리구조로 저장 ( 원산지인 A는 제외)
        Map<Character, Node> nodeMap = new HashMap<>();
        while(M--> 0) {
            st = new StringTokenizer(br.readLine());
            char key = st.nextToken().charAt(0);
            char value = st.nextToken().charAt(0);

            Node parent = nodeMap.getOrDefault(key, new Node(key));
            Node child = nodeMap.getOrDefault(value, new Node(value));

            parent.addChild(child);
            child.linkParent(key);

            nodeMap.put(key, parent);
            nodeMap.put(value, child);
        }
        // 검거현황 입력받아서, 각 공급책 별 차단 실시 -> 그 자식들 해당 부모에 대해 공급 차단됨
        st = new StringTokenizer(br.readLine());
        int blockNum = Integer.parseInt(st.nextToken());
        while(blockNum-- > 0) {
            char key = st.nextToken().charAt(0);
            nodeMap.get(key).block();
        }

        // N - 차단된 공급책수 출력
        int remainCnt = 0;
        for(Character key : nodeMap.keySet()) {
            Node node = nodeMap.get(key);
            if(!node.isRoot() && !node.isBlocked()) {
                remainCnt++;
            }
        }

        System.out.print(remainCnt);
    }

    static class Node {
        private final Character key;
        private final Map<Character, Boolean> parentLinks;
        private final List<Node> children;
        private boolean isBlocked;

        public Node(Character key) {
            this.key = key;
            parentLinks = new HashMap<>();
            children = new ArrayList<>();
            isBlocked = false;
        }

        public boolean isRoot() {
            return parentLinks.isEmpty();
        }

        public void addChild(Node child) {
            children.add(child);
        }

        public void linkParent(Character key) {
            parentLinks.put(key, true);
        }

        public void block() {
            isBlocked = true;
            for(Node child : children) {
                child.parentBlock(this.key);
            }
        }

        public void parentBlock(Character key) {
            if(parentLinks.containsKey(key)) {
                parentLinks.put(key, false);
            }

            if(checkBlocked()) {
                block();
            }
        }

        public boolean checkBlocked() {
            for(char key : parentLinks.keySet()) {
                if(parentLinks.get(key)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isBlocked() {
            return this.isBlocked;
        }
    }
}
