package com.company.neetcode;

import java.util.*;

public class Sliding_Window_Maximum {

    public static void main(String[] args) {

        int[] nums = {1,3,1,2,0,5};

        System.out.println(Arrays.toString(new Sliding_Window_Maximum().maxSlidingWindow(nums, 3)));

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = k - 1;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = l; i < r; i++) {
            if (deque.isEmpty()) {
                deque.add(nums[i]);
            } else {
                while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                    deque.removeLast();
                }
                deque.add(nums[i]);
            }
        }


        int[] ans = new int[nums.length - (k - 1)];

        while (r < nums.length) {
            while (!deque.isEmpty() && nums[r] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.add(nums[r]);

            ans[l] = deque.getFirst();

            if (ans[l] == nums[l]) {
                deque.pollFirst();
            }
            l++;
            r++;
        }
        return ans;
    }

    public int[] maxSlidingWindowPQ(int[] nums, int k) {
        int l = 0, r = k - 1;
        int[] max = new int[nums.length - (k - 1)];


        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = l; i < r; i++) {
            queue.add(nums[i]);
        }

        while (r < nums.length) {
            queue.offer(nums[r]);

            max[l] = queue.peek();

            queue.remove(nums[l]);
            l++;
            r++;
        }

        return max;

    }

    public int[] maxSlidingWindowBF(int[] nums, int k) {

        int l = 0, r = k - 1;

        int[] max = new int[nums.length - (k - 1)];

        while (r < nums.length) {
            int maxInWindow = Integer.MIN_VALUE;
            for (int i = l; i <= r; i++) {
                maxInWindow = Math.max(maxInWindow, nums[i]);
            }
            max[l] = maxInWindow;
            l++;
            r++;
        }

        return max;
    }
}
