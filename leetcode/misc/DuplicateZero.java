package com.company.leetcode.misc;

public class DuplicateZero {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new SolutionDZ().duplicateZeros(arr);
        for (int a : arr)
            System.out.print(a + " ");
    }
}

class SolutionDZ {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;
        for (int left = 0; left <= length_ - possibleDups; left++) {
            if (arr[left] == 0) {
                if (left == length_ - possibleDups) {
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }
        int last = length_ - possibleDups;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}

