package com.company.leetcode.fnew.hard;


public class _124_Binary_Tree_Maximum_Path_Sum {

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

    public static void main(String[] args) {

    }


    int max = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
        max(root);
        return max;
    }

    int max(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = max(root.left);
        int right = max(root.right);

        int sum = Math.max(Math.max(Math.max(left + right + root.val, root.val), root.val + left),
                root.val + right);

        max = Math.max(sum, max);

        return Math.max( root.val + Math.max(left, right), root.val);


    }


}
