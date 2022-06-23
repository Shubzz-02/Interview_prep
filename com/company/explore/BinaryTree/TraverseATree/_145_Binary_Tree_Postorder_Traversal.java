package com.company.com.company.explore.BinaryTree.TraverseATree;

import com.company.com.company.explore.BinaryTree.model.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class _145_Binary_Tree_Postorder_Traversal {

    public static void main(String[] args) {
        TreeNode bt = new TreeNode('F', new TreeNode('B', new TreeNode('A'),
                new TreeNode('D', new TreeNode('C'), new TreeNode('E'))),
                new TreeNode('G', null, new TreeNode('I', new TreeNode('H'), null)));
        new _145_Binary_Tree_Postorder_Traversal().postorderTraversal(bt).forEach((k) ->
                System.out.print((char)k.intValue()+" "));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {
        if (root != null) {
            traverse(root.left, res);
            traverse(root.right, res);
            res.add(root.val);
        }
    }

}
