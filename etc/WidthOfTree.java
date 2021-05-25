package com.company.etc;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfTree {

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }

    static int maxWidth(Node root) {
        if (root == null)
            return 0;
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            max = Math.max(count, max);

            while (count-- > 0) {
                Node temp = q.poll();
                if (temp != null && temp.left != null)
                    q.add(temp.left);
                if (temp != null && temp.right != null)
                    q.add(temp.right);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.left.left.left = new Node(7);
        root.left.right = new Node(8);
        root.left.left.left.right = new Node(9);
        System.out.println(maxWidth(root));
    }


}



