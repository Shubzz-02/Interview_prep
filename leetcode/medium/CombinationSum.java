package com.company.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new SolutionCS().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

class SolutionCS {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return result;
        Arrays.parallelSort(candidates);
        List<Integer> combination = new ArrayList<>();
        findCombination(result, combination, candidates, target, 0);
        return result;
    }

    private void findCombination(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int si) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = si; i < candidates.length; i++) {
            if (candidates[i] > target)
                return;
            combination.add(candidates[i]);
            findCombination(result, combination, candidates, target - candidates[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
