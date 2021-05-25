package com.company.etc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        arr = plusOne(arr);
        //System.out.println(Arrays.toString(arr));
        WTF();
    }

    private static int[] plusOne(int[] digits) {
        String arr = Arrays.toString(digits).trim().replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
        BigInteger big = new BigInteger(arr);
        big = big.add(new BigInteger("1"));
        String s = big.toString();
        int len = s.length();
        int[] arrr = new int[len];
        for (int i = 0; i < len; i++) {
            arrr[i] = Character.getNumericValue(s.charAt(i));
        }
        //System.out.println(Arrays.toString(arrr));
        return arrr;
    }

    static void WTF() {
        List<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
        List<Integer> tlist = list;
        tlist.set(2, 10);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
}
