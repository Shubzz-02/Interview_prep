package com.company.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Contains_Duplicate {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        System.out.println(new Contains_Duplicate().containsDuplicate(nums));
    }


    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        return set.size() != nums.length;

    }


}


// class MyersDiff {
//
//    public static List<String> diff(String a, String b) {
//        List<String> diff = new ArrayList<>();
//
//        int n = a.length();
//        int m = b.length();
//
//        // Initialize the grid
//        int[][] grid = new int[n + 1][m + 1];
//
//        for (int i = 0; i <= n; i++) {
//            grid[i][0] = i;
//        }
//
//        for (int j = 0; j <= m; j++) {
//            grid[0][j] = j;
//        }
//
//        // Compute the shortest edit script
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (a.charAt(i - 1) == b.charAt(j - 1)) {
//                    grid[i][j] = grid[i - 1][j - 1];
//                } else {
//                    int insert = grid[i][j - 1] + 1;
//                    int delete = grid[i - 1][j] + 1;
//                    int replace = grid[i - 1][j - 1] + 1;
//
//                    grid[i][j] = Math.min(insert, Math.min(delete, replace));
//                }
//            }
//        }
//
//        // Trace back the edit operations
//        int i = n;
//        int j = m;
//
//        while (i > 0 || j > 0) {
//            if (i > 0 && j > 0 && a.charAt(i - 1) == b.charAt(j - 1)) {
//                diff.add("UNCHANGED: " + a.charAt(i - 1));
//                i--;
//                j--;
//            } else if (i > 0 && grid[i][j] == grid[i - 1][j] + 1) {
//                diff.add("DELETED: " + a.charAt(i - 1));
//                i--;
//            } else {
//                diff.add("INSERTED: " + b.charAt(j - 1));
//                j--;
//            }
//        }
//
//        return diff;
//    }
//
//    public static void main(String[] args) {
//        String a = "Hello, world!\na";
//        String b = "a\nHello, openAI!";
//
//        List<String> diff = diff(a, b);
//
//        for (int i = diff.size() - 1; i >= 0; i--) {
//            System.out.println(diff.get(i));
//        }
//    }
//}
