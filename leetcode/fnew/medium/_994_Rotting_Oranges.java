package com.company.leetcode.fnew.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _994_Rotting_Oranges {

    public static void main(String[] args) {
        int[][] arr = {
                {0}
        };
        System.out.println(new _994_Rotting_Oranges().orangesRotting(arr));
    }

    public int orangesRotting(int[][] grid) {
        int[][] dir = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int totalTime = 0;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] curr = queue.remove();
                for (int j = 0; j < 4; j++) {
                    int x = curr[0] + dir[j][0];
                    int y = curr[1] + dir[j][1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            totalTime++;
        }
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return totalTime == 0 ? 0 : totalTime - 1;
    }

}
