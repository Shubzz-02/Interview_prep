package com.company.etc;

public class Sol {

    public static void main(String[] args) {

        int[] arr = {41};
        System.out.println(new Sol().makeEven(arr.length, arr));

    }

    public int makeEven(int q, int[] arr) {
        int total = 0;

        for (int i = 0; i < q; i++) {
            total += stepsToMakeEven(arr[i]);
        }
        return total;
    }

    private int stepsToMakeEven(int i) {
        if (i < 10) {
            return (i & 1) != 1 ? 0 : -1;
        }
        int evenDigit = -1;
        String no = Integer.toString(i);
        for (int j = 0; j < no.length(); j++) {
            if (((no.charAt(j) - '0') & 1) != 1) {
                evenDigit = j;
            }
        }
        if (evenDigit >= 0) {
            return (no.length() - 1) - evenDigit;
        } else {
            return -1;
        }
    }

}
