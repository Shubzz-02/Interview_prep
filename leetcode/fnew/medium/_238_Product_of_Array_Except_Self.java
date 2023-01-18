package com.company.leetcode.fnew.medium;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {

    public static void main(String[] args) {
        int[] num = {-1, 1, 0, -3, 3};

        System.out.println(
                Arrays.toString(new _238_Product_of_Array_Except_Self().productExceptSelf(num)));
    }

    public int[] productExceptSelf_ON_SPACE(int[] nums) {

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            postfix[(nums.length - 1) - i] =
                    postfix[(nums.length - 1) - i + 1] * nums[(nums.length - 1) - i];
        }

        int[] ans = new int[nums.length];

        ans[0] = postfix[1];
        ans[nums.length - 1] = prefix[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = prefix[i - 1] * postfix[i + 1];
        }

        return ans;
    }

    public int[] productExceptSelf(int[] nums) {

        int left = 1;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            right[i] = right[i] * left;
            left *= nums[i];
        }

        return right;
    }


}
