package com.company.leetcode.easy;

public class _1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {

    public static void main(String[] args) {
        int[] num = {2,3,1,2};
        System.out.println(
                new _1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing().canBeIncreasing(
                        num));

    }

    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isIncreasing(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIncreasing(int[] nums, int i) {
        int tmp = nums[i];
        nums[i] = -1;
        for (int j = 1; j < nums.length; j++) {
            if(nums[j] == -1) {
                nums[j] = nums[j-1];
                continue;
            }if (nums[j] <= nums[j - 1] ) {
                nums[i] = tmp;
                return false;
            }
        }
        nums[i] = tmp;
        return true;
    }

}
