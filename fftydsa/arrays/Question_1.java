package com.company.fftydsa.arrays;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.util.Arrays;

public class Question_1 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //new Solution_1().reverseArray(arr, arr.length);
        new Solution_1().reverseArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}


@Label("Reverse the given Array")
class Solution_1 {

    @Description("Iterative Approach")
    public void reverseArray(int[] arr, int len) {
        int start = 0, end = len - 1;
        while (start < end) {
            arr[start] = arr[start] ^ arr[end] ^ (arr[end] = arr[start]);
            start++;
            end--;
        }
    }

    @Description("Recursive Approach")
    public void reverseArray(int[] arr, int start, int end) {
        if (start >= end)
            return;
        arr[start] = arr[start] ^ arr[end] ^ (arr[end] = arr[start]);
        reverseArray(arr, start + 1, end - 1);
    }


}
