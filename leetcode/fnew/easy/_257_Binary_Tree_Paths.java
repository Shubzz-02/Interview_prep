package com.company.leetcode.fnew.easy;

import com.company.com.company.explore.BinaryTree.model.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _257_Binary_Tree_Paths {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        new _257_Binary_Tree_Paths().binaryTreePaths(bst).forEach(System.out::println);
    }

    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Stack<Pair<TreeNode, List<Integer>>> stack = new Stack<>();
        Pair<TreeNode, List<Integer>> pair = new Pair<>(root, new ArrayList<>(List.of(root.val)));

        stack.push(pair);
        while (!stack.isEmpty()) {
            Pair<TreeNode, List<Integer>> cp = stack.pop();
            TreeNode cn = cp.getKey();
            List<Integer> cl = cp.getValue();

            if (cn.right == null && cn.left == null) {
                ans.add(cl);
            }
            if (cn.left != null) {
                List<Integer> nl = new ArrayList<>(cl);
                nl.add(cn.left.val);
                stack.push(new Pair<>(cn.left, nl));
            }
            if (cn.right != null) {
                List<Integer> nl = new ArrayList<>(cl);
                nl.add(cn.right.val);
                stack.push(new Pair<>(cn.right, nl));
            }
        }
        return ans;

//        Stack<TreeNode> treeNodes = new Stack<>();
//        Stack<List<Integer>> path = new Stack<>();
//        treeNodes.add(root);
//        path.add(new ArrayList<>(List.of(root.val)));
//
//        while (!treeNodes.isEmpty()) {
//            TreeNode currNode = treeNodes.pop();
//            List<Integer> currPath = path.pop();
//            if (currNode.left == null && currNode.right == null) {
//                ans.add(currPath);
//            }
//            if (currNode.left != null) {
//                treeNodes.add(currNode.left);
//                currPath.add(currNode.left.val);
//                path.add(currPath);
//            }
//            if (currNode.right != null) {
//                treeNodes.add(currNode.right);
//                currPath.add(currNode.right.val);
//                path.add(currPath);
//            }
//        }
//        return ans;
    }

}
