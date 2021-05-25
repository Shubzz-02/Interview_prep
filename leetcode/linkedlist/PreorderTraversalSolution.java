package com.company.leetcode.linkedlist;

import com.company.leetcode.linkedlist.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversalSolution {
}

class SolutionPOT {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
