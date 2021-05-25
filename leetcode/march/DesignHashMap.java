package com.company.leetcode.march;

import java.util.Arrays;

public class DesignHashMap {
    public static void main(String[] args) {
        int key = 10;
        int value = 20;
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println( hashMap.get(1));
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}

class MyHashMap {
    int[] map;

    public MyHashMap() {
        map = new int[100_00_00];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }


    public int get(int key) {
        if (map[key] == -1)
            return -1;
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}


