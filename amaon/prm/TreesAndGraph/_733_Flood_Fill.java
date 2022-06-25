package com.company.amaon.prm.TreesAndGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _733_Flood_Fill {

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] newImage = new _733_Flood_Fill().floodFill(image, 1, 1, 2);
        for (int i = 0; i < newImage.length; i++) {
            System.out.println(Arrays.toString(newImage[i]));
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srcColor = image[sr][sc];
        if (color == srcColor) {
            return image;
        }
        int[][] dir = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] cp = queue.remove();

            image[cp[0]][cp[1]] = color;

            for (int i = 0; i < 4; i++) {
                int x = cp[0] + dir[i][0];
                int y = cp[1] + dir[i][1];

                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length
                        && image[x][y] == srcColor) {
                    queue.add(new int[]{x, y});
                }
            }
        }
        return image;
    }

}
