package com.company.leetcode.fnew.medium;

import java.util.HashMap;
import java.util.Map;

public class Dot_Product_of_Two_Sparse_Vectors_1570 {

    public static void main(String[] args) {
        int[] a = {1, 0, 0, 2, 3};
        int[] b = {0, 3, 0, 4, 0};

        SparseVector v1 = new SparseVector(a);
        SparseVector v2 = new SparseVector(b);

        System.out.println(v1.dotProduct(v2));
    }


}

//class SparseVector {
//
//    public int[] nums;
//
//    SparseVector(int[] nums) {
//        this.nums = nums;
//    }
//
//    // Return the dotProduct of two sparse vectors
//    public int dotProduct(SparseVector vec) {
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            ans += (this.nums[i] * vec.nums[i]);
//        }
//        return ans;
//    }
//}

class SparseVector {

    Map<Integer, Integer> map;

    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        int total = 0;
        for (Integer i : map.keySet()) {
            if (vec.map.containsKey(i)) {
                total += vec.map.get(i) * map.get(i);
            }
        }
        return total;
    }
}
