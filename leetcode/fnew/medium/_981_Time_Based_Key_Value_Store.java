package com.company.leetcode.fnew.medium;

import com.company.com.company.explore.BinaryTree.model.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _981_Time_Based_Key_Value_Store {

    public static void main(String[] args) {
        _981_Time_Based_Key_Value_Store.TimeMap timeMap = new _981_Time_Based_Key_Value_Store.TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));
    }

    static class TimeMap {

        Map<String, List<Pair<String, Integer>>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(new Pair<>(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            List<Pair<String, Integer>> value = map.get(key);
            return binarySearch(value, timestamp);
        }

        private String binarySearch(List<Pair<String, Integer>> value, int timestamp) {
            int l = 0;
            int r = value.size() - 1;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (value.get(mid).getValue() <= timestamp) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }

            return (value.get(l).getValue() <= timestamp) ? value.get(l).getKey() : "";
        }
    }

}
