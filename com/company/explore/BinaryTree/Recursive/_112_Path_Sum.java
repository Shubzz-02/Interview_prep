package com.company.com.company.explore.BinaryTree.Recursive;

import com.company.com.company.explore.BinaryTree.model.TreeNode;

public class _112_Path_Sum {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));
        System.out.println(new _112_Path_Sum().hasPathSum(bt, 'Z'));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

}
