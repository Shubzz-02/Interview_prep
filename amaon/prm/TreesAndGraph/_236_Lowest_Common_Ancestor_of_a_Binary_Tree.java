package com.company.amaon.prm.TreesAndGraph;

import com.company.com.company.explore.BinaryTree.model.Pair;
import com.company.com.company.explore.BinaryTree.model.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public static void main(String[] args) {
        TreeNode fiv = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));
        TreeNode one = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8));
        TreeNode bt = new TreeNode(3, fiv, one);

        System.out.println(
                new _236_Lowest_Common_Ancestor_of_a_Binary_Tree().lowestCommonAncestor(bt, fiv,
                        one).val);

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<List<TreeNode>> path = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Stack<Pair<TreeNode, List<TreeNode>>> stack = new Stack<>();
        Pair<TreeNode, List<TreeNode>> pair = new Pair<>(root, new ArrayList<>(List.of(root)));
        stack.push(pair);

        while (!stack.isEmpty()) {
            Pair<TreeNode, List<TreeNode>> currPair = stack.pop();
            TreeNode currNode = currPair.getKey();
            List<TreeNode> currList = currPair.getValue();

            if (currNode == p || currNode == q) {
                path.add(currList);
            }

            if (currNode.left != null) {
                List<TreeNode> cl = new ArrayList<>(currList);
                cl.add(currNode.left);
                stack.push(new Pair<>(currNode.left, cl));
            }
            if (currNode.right != null) {
                List<TreeNode> cl = new ArrayList<>(currList);
                cl.add(currNode.right);
                stack.push(new Pair<>(currNode.right, cl));
            }
        }

        int i = 0;
        int j = 0;
        while (i < path.get(0).size() && i < path.get(1).size() && path.get(0).get(i) == path.get(1)
                .get(i)) {
            i++;
        }

        return path.get(0).get(i - 1);
    }

}
