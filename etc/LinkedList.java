package com.company.etc;

public class LinkedList {

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(7, null);
        Node n5 = new Node(9, null);

        Node start = n1;
        Node n6 = new Node(6, null);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n6);
        n6.setNext(n4);
        n4.setNext(n5);
        System.out.println(n1.getVal());
    }


}
// 1 -> 2 -> 7 -> 5

class Node {
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }
}