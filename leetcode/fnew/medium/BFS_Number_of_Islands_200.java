package com.company.leetcode.fnew.medium;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Number_of_Islands_200 {

    public static void main(String[] args) {
        char[][] ch = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(new BFS_Number_of_Islands_200().numIslands(ch));
    }

    public int numIslands(char[][] grid) {
        int totalIsland = 0;

        int[][] dir = new int[][]{
                {-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}
        };

        int tr = grid.length;
        int tc = grid[0].length;

        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tc; j++) {
                if (grid[i][j] == '1') {
                    ++totalIsland;

                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] ci = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = ci[0] + dir[k][0];
                            int y = ci[1] + dir[k][1];
                            if (x >= 0 && x < tr && y >= 0 && y < tc && grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.add(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return totalIsland;
    }

}
