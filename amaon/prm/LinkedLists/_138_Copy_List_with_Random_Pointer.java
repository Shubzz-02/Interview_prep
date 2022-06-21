package com.company.amaon.prm.LinkedLists;

import java.util.HashMap;

public class _138_Copy_List_with_Random_Pointer {

    public static void main(String[] args) {
    }

    HashMap<Node, Node> visited = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node oldNode = head;
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode, newNode);

        while (oldNode != null) {
            newNode.random = getClonedNode(oldNode.random);
            newNode.next = getClonedNode(oldNode.next);

            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(head);
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (!visited.containsKey(node)) {
                visited.put(node, new Node(node.val));
            }
            return visited.get(node);
        }
        return null;
    }

    private class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
