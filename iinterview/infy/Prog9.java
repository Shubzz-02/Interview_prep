package com.company.iinterview.infy;

public class Prog9 {
    public static void main(String[] args) {
        System.out.println(removeElements(new int[]{5,6,7,8,1,2,3,4}));
    }

    public static int removeElements(int[] arr) {
        int tr = 0;
        int ci = 1;
        boolean op = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                op = true;
            if (arr[i] != ci) {
                tr++;
            } else {
                ci++;
            }
        }
        if (!op || tr == arr.length)
            return -1;
        return tr;
    }
}
