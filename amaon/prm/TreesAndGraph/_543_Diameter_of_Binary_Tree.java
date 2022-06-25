package com.company.amaon.prm.TreesAndGraph;

import com.company.com.company.explore.BinaryTree.model.TreeNode;

public class _543_Diameter_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode fiv = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));
        TreeNode one = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8));
        TreeNode bt = new TreeNode(3, fiv, one);

        System.out.println(new _543_Diameter_of_Binary_Tree().diameterOfBinaryTree(bt));
    }


    int diam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diam;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        diam = Math.max(diam, left + right);

        return (Math.max(left, right) + 1);
    }

}
