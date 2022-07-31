package com.company.amaon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {4, 2, 3, 4};
        System.out.println(getMinimumDays(
                Arrays.stream(arr).boxed().collect(java.util.stream.Collectors.toList())));
    }

    public static int getMinimumDays(List<Integer> parcels) {
        Set<Integer> uniqueIntegers = new HashSet<>(parcels);
        uniqueIntegers.remove(0);

        return uniqueIntegers.size();
    }

    public static int findMaximumSustainableClusterSize(List<Integer> processingPower,List<Integer> bootingPower, long powerMax){
        int max = 0;
        for(int i = 0; i < processingPower.size(); i++){
            int curr = processingPower.get(i);
            int boot = bootingPower.get(i);
            if(curr + boot <= powerMax){
                max = Math.max(max, curr + boot);
            }
        }
        return max;
    }

    public int maxLengthValidSubArray(List<Integer> processingPower,List<Integer> bootingPower, long powerMax){
        if(processingPower == null || bootingPower == null
                || processingPower.size() == 0 || processingPower.size() != bootingPower.size()){
            return 0;
        }

        PriorityQueue<Integer> maxBootingPower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int maxLength = 0;
        int currentLength = 1;

        int start = 0;
        int end = 0;

        int currentSumProcessingPower = processingPower.get(0);
        maxBootingPower.add(bootingPower.get(0));
        while(end < processingPower.size()){
            int currentBootingPower = maxBootingPower.peek();
            int currentPower = currentBootingPower + currentSumProcessingPower * currentLength;

            if(currentPower <= powerMax){
                maxLength = currentLength;
                end++;
                currentLength++;
            }
            else{
                currentSumProcessingPower -= processingPower.get(start);
                maxBootingPower.remove(bootingPower.get(start));
                start++;
                end++;
            }

            if(end < processingPower.size()){
                maxBootingPower.add(bootingPower.get(end));
                currentSumProcessingPower += processingPower.get(end);
            }
        }

        return maxLength;
    }
}
