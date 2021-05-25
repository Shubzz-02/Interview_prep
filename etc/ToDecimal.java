package com.company.etc;

import java.util.HashMap;

public class ToDecimal {

    static String fractionToDecimal(int numr, int denr) {
        String res = "";

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.clear();

        int rem = numr % denr;

        while ((rem != 0) && (!mp.containsValue(rem))) {
            mp.put(rem, res.length());

            rem = rem * 10;

            int res_part = rem / denr;
            res += String.valueOf(res_part);

            rem = rem % denr;
        }

        if (rem == 0)
            return "";
        else if (mp.containsKey(rem))
            return res.substring(mp.get(rem));

        return "";
    }

    // Driver code
    public static void main(String[] args) {
        int numr = 50, denr = 22;
        String res = fractionToDecimal(numr, denr);
        if (res == "")
            System.out.print("No recurring sequence");
        else
            System.out.print("Recurring sequence is "
                    + res);
    }
}

