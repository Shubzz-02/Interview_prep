package com.company.neetcode;

import com.company.etc.Array;

import java.util.Arrays;

public class Product_of_Array_Except_Self {


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(new Product_of_Array_Except_Self().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];


        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            postfix[nums.length - 1 - i] = postfix[nums.length - i] * nums[nums.length - 1 - i];
        }


        ;
        int[] ans = new int[nums.length];

        ans[0] = postfix[1];
        ans[ans.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = prefix[i - 1] * postfix[i + 1];
        }

        return ans;

    }
}
