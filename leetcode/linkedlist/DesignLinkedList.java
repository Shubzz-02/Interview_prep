package com.company.leetcode.linkedlist;

import java.util.LinkedList;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        list.get(1);
        list.deleteAtIndex(1);
        list.get(1);
    }
}

class MyLinkedList {
    LinkedList<Integer> list;

    public MyLinkedList() {
        list = new LinkedList<>();
    }

    public int get(int index) {
        if (index < list.size())
            return list.get(index);
        else
            return -1;
    }

    public void addAtHead(int val) {
        list.addFirst(val);
    }

    public void addAtTail(int val) {
        list.addLast(val);
    }


    public void addAtIndex(int index, int val) {
        if (index < list.size())
            list.add(index, val);
    }

    public void deleteAtIndex(int index) {
        if (list.size() != 0 && index < list.size())
            list.remove(index);
    }
}
