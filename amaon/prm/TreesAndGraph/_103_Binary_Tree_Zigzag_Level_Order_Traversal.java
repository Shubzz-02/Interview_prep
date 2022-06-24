package com.company.amaon.prm.TreesAndGraph;

import com.company.com.company.explore.BinaryTree.model.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public static void main(String[] args) {
        TreeNode bst = new TreeNode(10, new TreeNode(6, new TreeNode(1), new TreeNode(8)),
                new TreeNode(13, new TreeNode(11), new TreeNode(14)));
        new _103_Binary_Tree_Zigzag_Level_Order_Traversal().zigzagLevelOrder(bst).forEach(
                System.out::println);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int lvl = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cn = queue.remove();
                list.add(cn.val);

                if (cn.left != null) {
                    queue.add(cn.left);
                }
                if (cn.right != null) {
                    queue.add(cn.right);
                }
            }
            if (lvl % 2 == 0) {
                Collections.reverse(list);
            }
            lvl++;
            ans.add(list);
        }
        return ans;
    }

}
