package com.company.explore.BinarySearchTree.TraverseATree;

import java.util.LinkedList;
import java.util.Queue;

public class _662_Maximum_Width_of_Binary_Tree {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));

        System.out.println(new _662_Maximum_Width_of_Binary_Tree().widthOfBinaryTree(bt));
    }

    public int widthOfBinaryTree(TreeNode root) {
        return 0;
    }

}
