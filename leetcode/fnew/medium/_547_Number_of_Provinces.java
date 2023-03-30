package com.company.leetcode.fnew.medium;

import java.util.LinkedList;
import java.util.Queue;

public class _547_Number_of_Provinces {

    /*

     */

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}

        };

        System.out.println(new _547_Number_of_Provinces().findCircleNum(matrix));


    }


    public int findCircleNum(int[][] isConnected) {
        Queue<int[]> queue = new LinkedList<>();
        int total = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[i][i] == 1) {
                total++;
                queue.add(new int[]{i, i});
                while (!queue.isEmpty()) {
                    int[] curr = queue.remove();
                    isConnected[curr[0]][curr[1]] = -1;
                    for (int j = 0; j < isConnected[curr[1]].length; j++) {
                        if (isConnected[curr[1]][j] == 1) {
                            queue.add(new int[]{curr[1], j});
                        }
                    }
                }
            }
        }
        return total;
    }


}


