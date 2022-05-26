package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_39 {

    public static void main(String[] args) {

        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> list = new Combination_Sum_39().combinationSum(arr, 7);
        for (List<Integer> l : list) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), list);
        return list;
    }

    private void backtrack(int[] candidates, int i, int target, List<Integer> tempList,
            List<List<Integer>> list) {
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
        }
        if (target < 0) {
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            tempList.add(candidates[j]);
            backtrack(candidates, j, target - candidates[j], tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }

}
