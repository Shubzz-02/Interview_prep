package com.company.leetcode.fnew.easy;

import java.util.Stack;

public class Merge_Two_Binary_Trees_STACK_617 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null),
                new TreeNode(2, null, null));
        TreeNode node2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4, null, null)),
                new TreeNode(3, null, new TreeNode(4, null, null)));

        TreeNode node = new Merge_Two_Binary_Trees_617().mergeTrees(node1, node2);
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        Stack<TreeNode[]> stack = new Stack<>();

        stack.add(new TreeNode[]{root1, root2});
        while (!stack.isEmpty()) {
            TreeNode[] cn = stack.pop();

            if (cn[0] == null || cn[1] == null) {
                continue;
            }

            cn[0].val += cn[1].val;
            if (cn[0].left == null) {
                cn[0].left = cn[1].left;
            } else {
                stack.push(new TreeNode[]{cn[0].left, cn[1].left});
            }
            if (cn[0].right == null) {
                cn[0].right = cn[1].right;
            } else {
                stack.push(new TreeNode[]{cn[0].right, cn[0].right});
            }

        }
        return root1;
    }
}


