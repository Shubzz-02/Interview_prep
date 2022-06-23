package com.company.com.company.explore.BinaryTree.Recursive;

import com.company.com.company.explore.BinaryTree.model.Pair;
import com.company.com.company.explore.BinaryTree.model.TreeNode;
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

        if (root == null) {
            return 0;
        }
        int max = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()){
            Pair<TreeNode,Integer> cn = queue.peek();

            int currLvlSize = queue.size();
            Pair<TreeNode,Integer> elm = null;
            for (int i = 0; i < currLvlSize; i++) {
                elm = queue.remove();
                TreeNode node = elm.getKey();
                if(node.left!=null)
                    queue.add(new Pair<>(node.left,2*elm.getValue()));
                if(node.right!=null)
                    queue.add(new Pair<>(node.right,2*elm.getValue()+1));
            }
            max = Math.max(max,elm.getValue()-cn.getValue()+1);
        }
        return max;
    }

}
