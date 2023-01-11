package com.company.etc;

import java.util.HashSet;
import java.util.Set;

/*
Mission Agent Y
A neighborhood of Park Street is raided by soldiers in search of Agent Y. They land on different buildings on a helicopter. The rooftops of these buildings are connected to each other through ladders. Each soldier can take control of the buildings in a straight line (left- right and forward-backward), with respect to the building/position they have been dropped at. They cannot take control of buildings diagonally. There are 8 buildings in each row and column. Your goal is to determine and return the total number of buildings that are controlled by these group of soldiers. Note: A soldier also controls the building on which he/she is currently positioned/dropped Input Specification: input1: An integer value representing the number of soldiers that have landed input2: A 2-D array of size input1*2 representing 'x' and 'y' coordinate positions of the soldiers starting from {1,1} Output Specification: Return the total number of buildings that are controlled by the soldiers
 */
public class UserTest {


    public static void main(String[] args) {
        System.out.println(new UserTest().GetBuildingCount(1, new int[][]{
                {4,4}
        }));
    }


    public int GetBuildingCount(int input1, int[][] input2) {
        int[][] matrix = new int[8][8];
        for (int i = 0; i < input1; i++) {
            int x = input2[i][0];
            int y = input2[i][1];
            matrix[x - 1][y - 1] = 1;
        }
        setOnes(matrix);

        int count = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    count++;
                }

            }
        }
        return count;

    }

    public void setOnes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
