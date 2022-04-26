package com.company.leetcode.fnew.medium;

import com.company.etc.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int target = -1;

        List<List<Integer>> list = new FourSum_18().fourSum(nums, target);
        for (List<Integer> list1 : list) {
            System.out.println(list1);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l]<target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l]>target){
                        l--;
                    }else{
                        List<Integer> t = new ArrayList<Integer>();
                        t.add(nums[i]);
                        t.add(nums[j]);
                        t.add(nums[k]);
                        t.add(nums[l]);
                        res.add(t);

                        k++;
                        l--;

                        while(k<l &&nums[l]==nums[l+1] ){
                            l--;
                        }

                        while(k<l &&nums[k]==nums[k-1]){
                            k++;
                        }
                    }


                }
            }
        }
        return res;
    }
}
