package com.company.explore.BinarySearchTree.TraverseATree;

import java.util.Stack;

public class _111_Minimum_Depth_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));
        System.out.println(new _111_Minimum_Depth_of_Binary_Tree().minDepth(bt));
    }

    public int minDepth(TreeNode root) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        if (root == null) {
            return 0;
        }
        stack.add(new Pair<>(root, 1));

        int min = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            root = pair.getKey();
            if (root.left == null && root.right == null) {
                min = Math.min(min, pair.getValue());
            }
            if (root.left != null) {
                stack.add(new Pair<>(root.left, pair.getValue() + 1));
            }
            if (root.right != null) {
                stack.add(new Pair<>(root.right, pair.getValue() + 1));
            }
        }
        return min;
    }
}
