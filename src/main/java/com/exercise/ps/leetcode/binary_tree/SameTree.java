package main.java.com.exercise.ps.leetcode.binary_tree;

public class SameTree {

    public boolean isSameTree(CustomTreeNode p, CustomTreeNode q) {
        if(p == null) {
            if(q == null) return true;
            else return false;
        }
        else {
            if(q == null) return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
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
