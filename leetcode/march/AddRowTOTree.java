package com.company.leetcode.march;

import com.company.leetcode.linkedlist.helper.TreeNode;

public class AddRowTOTree {
}

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        insert(root, v, 1, d);
        return root;
    }

    private void insert(TreeNode root, int v, int depth, int d) {
        if (root == null)
            return;
        if (depth == d - 1) {
            TreeNode node = root.left;
            root.left = new TreeNode(v);
            root.left.left = node;
            node = root.right;
            root.right = new TreeNode(v);
            root.right.right = node;
        } else {
            insert(root.left, v, depth + 1, d);
            insert(root.right, v, depth + 1, d);
        }
    }
}
