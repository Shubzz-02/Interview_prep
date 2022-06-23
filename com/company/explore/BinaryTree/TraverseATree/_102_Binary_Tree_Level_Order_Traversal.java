package com.company.com.company.explore.BinaryTree.TraverseATree;

import com.company.com.company.explore.BinaryTree.model.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class _102_Binary_Tree_Level_Order_Traversal {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));
        new _102_Binary_Tree_Level_Order_Traversal().levelOrder(bt).forEach((i) ->
                System.out.println(
                        i.stream().map(o -> (char) o.intValue()).collect(Collectors.toList())));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cn = queue.remove();
                subLevel.add(cn.val);
                if (cn.left != null) {
                    queue.add(cn.left);
                }
                if (cn.right != null) {
                    queue.add(cn.right);
                }
            }
            ans.add(subLevel);

        }
        return ans;

    }

}
