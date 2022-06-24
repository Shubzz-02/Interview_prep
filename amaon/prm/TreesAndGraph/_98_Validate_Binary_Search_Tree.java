package com.company.amaon.prm.TreesAndGraph;

import com.company.com.company.explore.BinaryTree.model.TreeNode;

public class _98_Validate_Binary_Search_Tree {

    public static void main(String[] args) {

        TreeNode bst = new TreeNode(10, new TreeNode(6, new TreeNode(1), new TreeNode(8)),
                new TreeNode(13, new TreeNode(11), new TreeNode(14)));

        System.out.println(new _98_Validate_Binary_Search_Tree().isValidBST(bst));

    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
        return validate(root.right, root.val, high) && validate(root.left, low, root.val);
    }
}
