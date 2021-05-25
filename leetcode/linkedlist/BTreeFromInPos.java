package com.company.leetcode.linkedlist;

import com.company.leetcode.linkedlist.helper.TreeNode;

public class BTreeFromInPos {
}

class SolutionInPos {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int posStart = 0;
        int posEnd = postorder.length - 1;
        return buildTree(inorder, postorder, inStart, inEnd, posStart, posEnd);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int posEnd) {
        if (inStart > inEnd || posStart > posEnd)
            return null;
        int rootValue = postorder[posEnd];
        TreeNode node = new TreeNode(rootValue);
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }
        node.left = buildTree(inorder,postorder,inStart,k-1,posStart,posStart+k-(inStart+1));
        node.right = buildTree(inorder,postorder,k+1,inEnd,posStart+k-inStart,posEnd-1);
        return node;
    }
}
