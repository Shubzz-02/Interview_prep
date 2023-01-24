package com.company.leetcode.fnew.medium;

import java.util.Arrays;
import java.util.Comparator;

public class _853_Car_Fleet {

    public static void main(String[] args) {
        int[] pos = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(new _853_Car_Fleet().carFleet(12, pos, speed));
    }

    static class Cars {

        int pos;
        double timeToReach;

        public Cars(int pos, double timeToReach) {
            this.pos = pos;
            this.timeToReach = timeToReach;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Cars[] cars = new Cars[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Cars(position[i], ((target - position[i]) / (double) speed[i]));
        }

        Arrays.sort(cars, Comparator.comparingInt(a -> a.pos));
        int res = 0;
        for (int i = position.length - 1; i > 0; i--) {
            if (cars[i].timeToReach >= cars[i - 1].timeToReach) {
                cars[i - 1] = cars[i];
            } else {
                res++;
            }
        }

        return res + 1;
    }

}
