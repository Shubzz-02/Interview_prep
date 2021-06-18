package com.company.fftydsa.arrays;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.util.Arrays;

public class Question_3 {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int[] ans = new Solution_3().k_Small_large(arr, 0, arr.length, 3);
        System.out.println(Arrays.toString(ans));
    }
}

@Label("Kth smallest element and Largest Number")
class Solution_3 {


    @Description("Simple Sorting Logic")
    public int[] k_Small_large(int[] arr, int l, int r, int k) {
        Arrays.sort(arr);
        return new int[]{arr[l + k-1], arr[r - k]};
    }


}
