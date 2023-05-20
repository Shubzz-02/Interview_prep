package com.company.neetcode;

import java.util.*;

public class Top_K_Frequent_Elements {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3};

        System.out.println(Arrays.toString(new Top_K_Frequent_Elements().topKFrequent(arr, 2)));

    }

    public int[] topKFrequent(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int i = 0;
        int[] ans = new int[k];
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll().getKey();
        }
        return ans;
    }


}
