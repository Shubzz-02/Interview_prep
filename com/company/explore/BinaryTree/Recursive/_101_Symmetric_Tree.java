package com.company.com.company.explore.BinaryTree.Recursive;

import com.company.com.company.explore.BinaryTree.model.TreeNode;

public class _101_Symmetric_Tree {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));
        System.out.println(new _101_Symmetric_Tree().isSymmetric(bt));
    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val && isMirror(left.right, right.left)) && isMirror(left.left,
                right.right);
    }


}
