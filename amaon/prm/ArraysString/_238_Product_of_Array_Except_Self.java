package com.company.amaon.prm.ArraysString;

import java.util.Arrays;

public class _238_Product_of_Array_Except_Self {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(
                Arrays.toString(new _238_Product_of_Array_Except_Self().productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }
        return ans;
    }

}
