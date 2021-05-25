package com.company.leetcode.misc;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        arr = new SolutionSAP().sortArrayByParity(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class SolutionSAP {
    public int[] sortArrayByParity(int[] A) {
        int[] e = Arrays.stream(A).filter(i -> ((i % 2) == 0)).toArray();
        int[] o = Arrays.stream(A).filter(i -> ((i % 2) != 0)).toArray();
        int[] ans = new int[A.length];
        System.arraycopy(e, 0, ans, 0, e.length);
        System.arraycopy(o, 0, ans, e.length, o.length);
        return ans;
    }
}
