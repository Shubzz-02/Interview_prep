package com.company.etc;

import java.util.Arrays;
import java.util.TreeMap;

public class UserTest2 {

    public static void main(String[] args) {

        int[] arr = new UserTest2().SortStudentMarks(3, 3, new int[][]{
                {50,30,70},
                {30,70,99},
                {99,20,30}
        });
        System.out.println(Arrays.toString(arr));

    }

    public int[] SortStudentMarks(int input1, int input2, int[][] input3) {
        int[] answer = new int[input1];
        TreeMap<Double, Integer> map = new TreeMap<>();

        for (int i = 0; i < input2; i++) {
            double avg = 0d;
            for (int j = 0; j < input1; j++) {
                avg += input3[j][i];
            }
            avg /= input1;
            map.put(avg, i);
        }

        int ignore = map.get(map.firstKey());

        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input2; j++) {
                if (j != ignore) {
                    answer[i] += input3[i][j];
                }
            }
        }
        return answer;
    }
}
