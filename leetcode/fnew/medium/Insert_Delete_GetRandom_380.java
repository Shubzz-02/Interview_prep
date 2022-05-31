package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Insert_Delete_GetRandom_380 {

    public static void main(String[] args) {

    }

}

class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;

    Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int lastElement = list.get(list.size() - 1);
        int valIndex = map.get(val);
        list.set(valIndex, lastElement);
        map.put(lastElement, valIndex);
        map.put(list.size() - 1, val);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}