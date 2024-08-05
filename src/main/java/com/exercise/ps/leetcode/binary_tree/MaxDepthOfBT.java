package main.java.com.exercise.ps.leetcode.binary_tree;

import javax.swing.tree.TreeNode;

public class MaxDepthOfBT {
    private int maxDepth = 0;

    public int maxDepth(CustomTreeNode root) {
        if (root == null) return 0;
        findDepth(root, 1);
        return maxDepth;
    }

    private void findDepth(CustomTreeNode current, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        if (current.left != null)
            findDepth(current.left, depth + 1);
        if (current.right != null)
            findDepth(current.right, depth + 1);
    }

    public static class CustomTreeNode {
        int val;
        CustomTreeNode left;
        CustomTreeNode right;

        CustomTreeNode() {
        }

        CustomTreeNode(int val) {
            this.val = val;
        }

        CustomTreeNode(int val, CustomTreeNode left, CustomTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
