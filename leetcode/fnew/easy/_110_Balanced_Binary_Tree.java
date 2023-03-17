package com.company.leetcode.fnew.easy;

public class _110_Balanced_Binary_Tree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isBalanced(TreeNode root) {

        int left = 0;
        int right = 0;

        if (root == null) {
            return true;
        }

        left = height(root.left);
        right = height(root.right);

        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);

    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }


}
