package com.company.leetcode.fnew.easy;

public class Merge_Two_Binary_Trees_617 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, new TreeNode(3, new TreeNode(5, null, null), null),
                new TreeNode(2, null, null));
        TreeNode node2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4, null, null)),
                new TreeNode(3, null, new TreeNode(4, null, null)));

        TreeNode node = new Merge_Two_Binary_Trees_617().mergeTrees(node1, node2);

        Merge_Two_Binary_Trees_617.printBinaryTree(node);
    }

    public static void printBinaryTree(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val+" ");
        printBinaryTree(node.left);
        printBinaryTree(node.right);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
