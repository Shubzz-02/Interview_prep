package com.company.explore.BinarySearchTree.TraverseATree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_BinaryTree_InOrder_Traversal {

    public static void main(String[] args) {

        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));

        //System.out.println(new _94_BinaryTree_InOrder_Traversal().inorderTraversal(bt).stream());
        new _94_BinaryTree_InOrder_Traversal().inorderTraversal(bt).forEach((k) ->
                System.out.print((char) k.intValue() + " "));

    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        traverse(root, res);
//        return res;
//    }
//
//    private void traverse(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            traverse(root.left, res);
//            res.add(root.val);
//            traverse(root.right, res);
//        }
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;

    }


}
