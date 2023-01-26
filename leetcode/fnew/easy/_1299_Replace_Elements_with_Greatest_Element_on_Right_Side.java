package com.company.leetcode.fnew.easy;

import java.util.Arrays;
import java.util.Stack;

public class _1299_Replace_Elements_with_Greatest_Element_on_Right_Side {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        System.out.println(
                Arrays.toString(
                        new _1299_Replace_Elements_with_Greatest_Element_on_Right_Side().replaceElements(
                                arr)));
    }

    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];

        ans[arr.length - 1] = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            ans[i] = stack.peek();
            if (arr[i] > stack.peek()) {
                stack.push(arr[i]);
            }
        }

        return ans;
    }

}
