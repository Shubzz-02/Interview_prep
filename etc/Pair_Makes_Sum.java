package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Pair_Makes_Sum {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //Input should be in comma separated format like given in example like :  1,3,4,5,11,12,15,16
            int[] arr = Arrays.stream(br.readLine().trim().split(",")).mapToInt(Integer::parseInt)
                    .toArray();
            int target = Integer.parseInt(br.readLine());
            getPairSum(arr, target);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getPairSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        boolean flag = false;
        for (int j : arr) {
            int t = target - j;
            if (set.contains(t)) {
                System.out.println(true + " | " + t + " " + j);
                flag = true;
                break;
            }
            set.add(j);
        }
        if (!flag) {
            System.out.println(false);
        }
    }

}
