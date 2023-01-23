package com.company.leetcode.fnew.medium;

public class _155_Min_Stack {

    public static void main(String[] args) {

    }


    class MinStack {

        Node node;

        public MinStack() {
        }

        public void push(int val) {
            if (node == null) {
                node = new Node(val, val, null);
            } else {
                node = new Node(Math.min(node.min, val), val, node);
            }
        }

        public void pop() {
            Node tmp = node;
            node = node.next;
            tmp.next = null;
        }

        public int top() {
            return node.val;
        }

        public int getMin() {
            return node.min;
        }

        private class Node {

            int min;
            int val;
            Node next;

            public Node(int min, int val, Node next) {
                this.min = min;
                this.val = val;
                this.next = next;
            }
        }
    }

}
