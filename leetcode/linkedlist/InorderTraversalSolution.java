package com.company.leetcode.linkedlist;

import com.company.leetcode.linkedlist.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalSolution {
}

class SolutionIO {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        return list;
    }
}
