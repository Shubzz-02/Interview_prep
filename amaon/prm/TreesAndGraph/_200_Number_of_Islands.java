package com.company.amaon.prm.TreesAndGraph;

import java.util.LinkedList;
import java.util.Queue;

public class _200_Number_of_Islands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }
        };

        System.out.println(new _200_Number_of_Islands().numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int[][] dir = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        int total = 0;
        int tr = grid.length;
        int tc = grid[0].length;

        for (int i = 0; i < tr; i++) {
            for (int j = 0; j < tc; j++) {
                if (grid[i][j] == '1') {
                    total++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    grid[i][j] = '0';
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
        return total;
    }

}
