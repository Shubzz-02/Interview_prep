package com.company.etc;

import java.util.LinkedList;
import java.util.Queue;


public class UserMainCode {

    public static void main(String[] args) {
        System.out.println(new UserMainCode().minSteps(3, 2));
    }


    public int minSteps(int input1, int input2) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});
        int steps = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int x = curr[0];
            int y = curr[1];
            int s = curr[2];

            if (x == input1 && y == input2) {
                steps = Math.min(steps, s);
            }

            if (x + y <= input1) {
                queue.add(new int[]{x + y, y, s + 1});
            }
            if (y + x <= input2) {
                queue.add(new int[]{x, y + x, s + 1});
            }
        }
        return (steps != Integer.MAX_VALUE ? steps : -1);

    }


}
