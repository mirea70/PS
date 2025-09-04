package com.exercise.ps.Baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        HashMap<Character, Node> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char rootVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);

            Node node = map.computeIfAbsent(rootVal, k -> new Node(k));
            node.setLeft(leftVal == '.' ? null : map.computeIfAbsent(leftVal, k -> new Node(k)));
            node.setRight(rightVal == '.' ? null : map.computeIfAbsent(rightVal, k -> new Node(k)));
        }

        StringBuilder totalSb = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        Node root = map.get('A');

        preAround(sb, root);
        totalSb.append(sb).append("\n");
        sb.setLength(0);

        midAround(sb, root);
        totalSb.append(sb).append("\n");
        sb.setLength(0);

        postAround(sb, root);
        totalSb.append(sb);
        sb.setLength(0);

        System.out.print(totalSb);
    }

    // 전위 순회
    private static void preAround(StringBuilder sb, Node root) {
        // 현재값
        sb.append(root.val);
        // 좌측노드탐색
        if(root.left != null) {
            preAround(sb, root.left);
        }
        // 우측노드탐색
        if(root.right != null) {
            preAround(sb, root.right);
        }
    }
    // 중위 순회
    private static void midAround(StringBuilder sb, Node root) {
        // 좌측노드탐색
        if(root.left != null) {
            midAround(sb, root.left);
        }
        // 현재값
        sb.append(root.val);
        // 우측노드탐색
        if(root.right != null) {
            midAround(sb, root.right);
        }
    }
    // 후위 순회
    private static void postAround(StringBuilder sb, Node root) {
        // 좌측노드탐색
        if(root.left != null) {
            postAround(sb, root.left);
        }
        // 우측노드탐색
        if(root.right != null) {
            postAround(sb, root.right);
        }
        // 현재값
        sb.append(root.val);
    }

    static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
