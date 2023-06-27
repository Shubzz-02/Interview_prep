package com.company.neetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Car_Fleet {

    public static void main(String[] args) {

        System.out.println(new Car_Fleet().carFleet(10, new int[]{6, 8}, new int[]{3, 2}));

    }

    static class Car {

        private int pos;
        private double timeTOReach;

        public Car(int pos, double timeTOReach) {
            this.pos = pos;
            this.timeTOReach = timeTOReach;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public double getTimeTOReach() {
            return timeTOReach;
        }

        public void setTimeTOReach(double timeTOReach) {
            this.timeTOReach = timeTOReach;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        Car[] cars = new Car[position.length];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], (target - position[i]) / (double) speed[i]);
        }

        Arrays.sort(cars, Comparator.comparing(Car::getPos));

        int totalFleet = 0;

        for (int i = cars.length - 1; i > 0; i--) {

            if (cars[i].getTimeTOReach() >= cars[i - 1].getTimeTOReach()) {
                cars[i - 1] = cars[i];
            } else {
                totalFleet++;
            }
        }

        return totalFleet + 1;
    }
}
