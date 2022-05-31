package com.company.leetcode.fnew.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Largest_Element_Array_215 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(new Kth_Largest_Element_Array_215().findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(n -> n));

        for (int num : nums) {
                priorityQueue.add(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.poll();
    }
}
