package com.company.etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
                {0, 0, 0, 0, 0, 2, 5, 4},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 2, 0, 3, 0,},
                [[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
 */
public class ChangeZeroColRow {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 5},
                {4, 3, 1, 4},
                {0, 1, 1, 4},
                {1, 2, 1, 3},
                {0, 0, 1, 1}
        };

        new SolutionCHG().changeArray(grid);
        for (int[] i : grid)
            System.out.println(Arrays.toString(i));
    }
}


class SolutionCHG {
    public void changeArray(int[][] grid) {
        if (grid.length == 0)
            return;
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 0)
                    set.add(new int[]{i, j});

        for (int[] rc : set) {
            int r = rc[0], c = rc[1];
            for (int i = r; i >= 0; i--)
                grid[i][c] = 0;
            for (int i = r; i < grid.length; i++)
                grid[i][c] = 0;
            for (int i = c; i >= 0; i--)
                grid[r][i] = 0;
            for (int i = c; i < grid[r].length; i++)
                grid[r][i] = 0;
        }
    }
}

