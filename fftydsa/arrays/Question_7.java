package com.company.fftydsa.arrays;

import jdk.jfr.Description;
import jdk.jfr.Label;

import java.util.Arrays;

public class Question_7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        new Solution_7().rotateN(arr);
        System.out.println(Arrays.toString(arr));
    }
}


@Label("Write a program to cyclically rotate an array by one.")
class Solution_7 {

    @Description("Naive approach")
    public void rotateN(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i != j) {
            arr[i] = arr[i] ^ arr[j] ^ (arr[j] = arr[i]);
            i++;
        }
    }



}
