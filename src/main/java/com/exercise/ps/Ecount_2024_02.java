package com.exercise.ps;


import java.io.*;
import java.util.*;

public class Ecount_2024_02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 처리
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 높이별 인덱스 그룹화
        Map<Integer, List<Integer>> heightMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            heightMap.putIfAbsent(heights[i], new ArrayList<>());
            heightMap.get(heights[i]).add(i);
        }

        // 구간 내 최댓값을 위한 Segment Tree 구축
        SegmentTree segTree = new SegmentTree(heights);

        int bridgeCount = 0;

        // 각 높이에 대해 하늘다리 검증
        for (Map.Entry<Integer, List<Integer>> entry : heightMap.entrySet()) {
            List<Integer> indices = entry.getValue();
            int size = indices.size();

            // 같은 높이의 모든 쌍 (i, j)을 확인
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int left = indices.get(i);
                    int right = indices.get(j);

                    // 구간 내 최댓값 확인
                    if (segTree.query(left + 1, right - 1) < heights[left]) {
                        bridgeCount++;
                    }
                }
            }
        }

        // 결과 출력
        System.out.print(bridgeCount);
    }
}

class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr) {
        this.n = arr.length;
        this.tree = new int[2 * n];
        build(arr);
    }

    private void build(int[] arr) {
        // 리프 노드 채우기
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }
        // 내부 노드 채우기
        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.max(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public int query(int left, int right) {
        left += n; // 리프 노드 시작점으로 이동
        right += n; // 리프 노드 시작점으로 이동
        int maxVal = Integer.MIN_VALUE;

        while (left <= right) {
            if (left % 2 == 1) { // 왼쪽이 홀수인 경우
                maxVal = Math.max(maxVal, tree[left]);
                left++;
            }
            if (right % 2 == 0) { // 오른쪽이 짝수인 경우
                maxVal = Math.max(maxVal, tree[right]);
                right--;
            }
            left /= 2;
            right /= 2;
        }

        return maxVal;
    }
}

//class SegmentTree {
//    private int[] tree;
//    private int[] arr;
//    private int n;
//
//    public SegmentTree(int[] arr) {
//        this.n = arr.length;
//        this.arr = arr;
//        this.tree = new int[4 * n];
//        build(0, n - 1, 1);
//    }
//
//    private void build(int start, int end, int node) {
//        if (start == end) {
//            tree[node] = arr[start];
//            return;
//        }
//
//        int mid = (start + end) / 2;
//        build(start, mid, node * 2);
//        build(mid + 1, end, node * 2 + 1);
//        tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
//    }
//
//    public int query(int left, int right) {
//        if (left > right) return Integer.MIN_VALUE; // 범위가 없는 경우
//        return query(0, n - 1, 1, left, right);
//    }
//
//    private int query(int start, int end, int node, int left, int right) {
//        if (right < start || end < left) {
//            return Integer.MIN_VALUE;
//        }
//        if (left <= start && end <= right) {
//            return tree[node];
//        }
//
//        int mid = (start + end) / 2;
//        int leftMax = query(start, mid, node * 2, left, right);
//        int rightMax = query(mid + 1, end, node * 2 + 1, left, right);
//        return Math.max(leftMax, rightMax);
//    }
//}