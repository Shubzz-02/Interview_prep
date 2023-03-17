package com.company.leetcode.fnew.easy;

public class _543_Diameter_of_Binary_Tree {


    public static void main(String[] args) {

    }
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return max;

    }

    int height(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
