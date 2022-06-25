package com.company.amaon.prm.TreesAndGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class _675_Cut_Off_Trees_for_Golf_Event {


    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(List.of(1, 2, 3));
        grid.add(List.of(0, 0, 4));
        grid.add(List.of(7, 6, 5));

        System.out.println(new _675_Cut_Off_Trees_for_Golf_Event().cutOffTree(grid));
    }

        public int cutOffTree(List<List<Integer>> forest) {

            if (forest == null || forest.size() == 0) {
                return -1;
            }
            int row = forest.size();
            int col = forest.get(0).size();
            int res = 0;
            List<int[]> heights = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (forest.get(i).get(j) > 1) {
                        heights.add(new int[]{forest.get(i).get(j), i, j});
                    }
                }
            }

            heights.sort(Comparator.comparingInt(o -> o[0]));
            int start_x = 0, start_y = 0;
            for (int[] height : heights) {
                int cnt_step = bfs(forest, row, col, start_x, start_y, height[1],
                        height[2]);
                if (cnt_step == -1) {
                    return -1;
                }
                res += cnt_step;
                start_x = height[1];
                start_y = height[2];
            }
            return res;
        }

        private int bfs(List<List<Integer>> forest, int row, int col, int start_x, int start_y,
                int dest_x, int dest_y) {
            if (start_x == dest_x && start_y == dest_y) {
                return 0;
            }
            int[][] dir = {
                    {0, 1},
                    {0, -1},
                    {1, 0},
                    {-1, 0}
            };
            int step = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start_x, start_y});
            int[][] visited = new int[row][col];
            visited[start_x][start_y] = 1;
            while (!queue.isEmpty()) {
                int qSize = queue.size();
                step++;
                while (qSize-- > 0) {
                    int[] curr = queue.remove();
                    int curr_x = curr[0];
                    int curr_y = curr[1];

                    for (int i = 0; i < 4; i++) {
                        int x = curr_x + dir[i][0];
                        int y = curr_y + dir[i][1];

                        if (x >= 0 && x < row && y >= 0 && y < col && forest.get(x).get(y) > 0
                                && visited[x][y] == 0) {
                            if (x == dest_x && y == dest_y) {
                                return step;
                            }
                            visited[x][y] = 1;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
            return -1;
        }

}
