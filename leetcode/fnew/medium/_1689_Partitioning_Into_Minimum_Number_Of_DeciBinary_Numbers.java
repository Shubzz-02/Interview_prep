package com.company.leetcode.fnew.medium;

public class _1689_Partitioning_Into_Minimum_Number_Of_DeciBinary_Numbers {

    public static void main(String[] args) {

        String n = "32";
        System.out.println(
                new _1689_Partitioning_Into_Minimum_Number_Of_DeciBinary_Numbers().minPartitions(
                        n));

    }

    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(max, n.charAt(i) - '0');
        }
        return max;
//        int[] arr = new int[n.length()];
//        for (int i = 0; i < n.length(); i++) {
//            arr[i] = n.charAt(i) - '0';
//        }
//
//        Arrays.sort(arr);
//        return arr[arr.length - 1];
    }

}
