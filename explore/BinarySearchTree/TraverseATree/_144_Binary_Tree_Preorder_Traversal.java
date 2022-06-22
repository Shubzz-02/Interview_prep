package com.company.explore.BinarySearchTree.TraverseATree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_Binary_Tree_Preorder_Traversal {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(new _144_Binary_Tree_Preorder_Traversal().preorderTraversal(bt));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cn = stack.pop();
            ans.add(cn.val);
            if (cn.right != null) {
                stack.push(cn.right);
            }
            if (cn.left != null) {
                stack.push(cn.left);
            }
        }
        return ans;
    }

}
