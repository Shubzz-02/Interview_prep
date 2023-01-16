package com.company.leetcode.fnew.medium;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _347_Top_K_Frequent_Elements {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(
                Arrays.toString(new _347_Top_K_Frequent_Elements().topKFrequent(nums, k)));

    }

    public int[] topKFrequent(int[] nums, int k) {

        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>(
                Comparator.comparingInt(Entry::getValue));

        for (Map.Entry<Integer,Integer> i : map.entrySet()){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }


        int i = k;

        while (!pq.isEmpty()){
            ans[--i] = pq.poll().getKey();
        }

        return ans;

    }

}
