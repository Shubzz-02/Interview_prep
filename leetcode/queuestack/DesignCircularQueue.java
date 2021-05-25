package com.company.leetcode.queuestack;

public class DesignCircularQueue {
}


class MyCircularQueue {
    private Node head = null;
    private Node rear = null;
    private int totalLength = 0;
    private int currentLength = 0;

    public MyCircularQueue(int k) {
        this.totalLength = k;
    }

    public boolean enQueue(int value) {
        if (this.currentLength == this.totalLength) {
            return false;
        }
        this.currentLength++;
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            rear = newNode;

            return true;
        }

        rear.next = newNode;
        rear = newNode;
        return true;
    }

    public boolean deQueue() {
        if (this.currentLength == 0) {
            return false;
        }

        this.currentLength--;
        if (head == rear) {
            head = rear = null;
            return true;
        }

        head = head.next;
        return true;

    }

    public int Front() {
        if (this.currentLength == 0) {
            return -1;
        }

        return head.val;
    }

    public int Rear() {
        if (this.currentLength == 0) {
            return -1;
        }

        return rear.val;
    }

    public boolean isEmpty() {
        return this.currentLength == 0;
    }

    public boolean isFull() {
        return this.currentLength == this.totalLength;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
