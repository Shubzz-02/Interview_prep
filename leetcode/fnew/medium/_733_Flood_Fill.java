package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _733_Flood_Fill {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};

        int[][] bus = {
                {6, 2},
                {10, 17},
                {34, 42},
                {56, 65},
                {100, 101},
                {105, 110},
                {115, 119}
        };

        arr = new _733_Flood_Fill().floodFill(arr, 1, 1, 2);
        Arrays.stream(arr).forEach(
                k -> System.out.println(Arrays.toString(k))
        );
//        System.out.println(_733_Flood_Fill.flo(bus));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) {
            return image;
        }
        int[][] dir = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{sr, sc});
        int replace = image[sr][sc];
        image[sr][sc] = color;
        while (!queue.isEmpty()) {

            int[] curr = queue.remove();
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dir[i][0];
                int y = curr[1] + dir[i][1];

                if (x >= 0 && x < image.length && y >= 0 && y < image[x].length
                        && image[x][y] == replace) {

                    image[x][y] = color;
                    queue.add(new int[]{x, y});
                }
            }

        }
        return image;
    }

    public static int busRemaining(int[][] busStation) {
        List<int[]> ans = new ArrayList<>();
        int[][] arr = Arrays.copyOfRange(busStation, 1, busStation.length);

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        Arrays.stream(arr).forEach(
                k -> System.out.println(Arrays.toString(k))
        );
        int start = arr[0][0];
        int end = arr[0][1];
        System.out.println("start" + start + "end" + end + "\n");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= start && arr[i][0] <= end) {

                end = Math.max(arr[i][1], end);
            } else {
                System.out.println("start" + start + "end" + end);
                ans.add(new int[]{start, end});
                start = arr[i][0];
                end = arr[i][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.size();
    }
}
