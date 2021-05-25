package com.company.leetcode.linkedlist;

import com.company.leetcode.linkedlist.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversalSolution {
}

class SolutionPOTC {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
