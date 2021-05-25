package com.company.leetcode.easy;

public class Problem1 {
    /*
    1,9,2,3,4
1,2,3,4,9
2,3,4,1,9
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1, 9};
        System.out.println(max_diff(arr));
    }

    static int max_diff(int[] arr) {
        int len = arr.length;
        int md = arr[1] - arr[0];
        int min = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] - min > md)
                md = arr[i] - min;
            if (arr[i] < min)
                min = arr[i];
        }
        return md;
    }

    static int f(int x){
        f(x);
        return x;
    }


}
