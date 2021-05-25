package com.company.leetcode.misc;

public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(new SolutionVMA().validMountainArray(new int[]{0,3,2,1}));
    }
}

class SolutionVMA {
    public boolean validMountainArray(int[] arr) {
        int n= arr.length;
        int i=0;
        while (i+1<n && arr[i] < arr[i+1])
            i++;
        if(i==0 || i==n-1)
            return false;
        while (i+1<n && arr[i] > arr[i+1])
            i++;
        return i==n-1;
    }
}
