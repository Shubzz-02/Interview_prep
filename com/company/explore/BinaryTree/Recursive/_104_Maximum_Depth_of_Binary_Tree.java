package com.company.com.company.explore.BinaryTree.Recursive;

import com.company.com.company.explore.BinaryTree.model.TreeNode;

public class _104_Maximum_Depth_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));
        System.out.println(new _104_Maximum_Depth_of_Binary_Tree().maxDepth(bt));
    }

    int ans = 0;

    public int maxDepth(TreeNode root) {
        max_depth(root, 0);
        return ans;
    }


    public void max_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans = Math.max(ans, depth);
        }
        max_depth(root.left, depth + 1);
        max_depth(root.right, depth + 1);
    }

    public int maxDepth2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth2(node.left);
        int right = maxDepth2(node.right);
        return Math.max(left, right);
    }

}
