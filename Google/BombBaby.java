package com.company.Google;

public class BombBaby {

    public static String solution(String x, String y) {
        long m = Long.parseLong(x);
        long f = Long.parseLong(y);
        long generations = 0;
        while (m > 1 && f > 1) {
            if (m < f) {
                long temp = m;
                m = f;
                f = temp;
            }
            if (m % f == 0) {
                return "impossible";
            }
            long times = m / f;
            generations += times;
            m -= f * times;
        }
        if (m == 1 || f == 1) {
            return String.valueOf(generations + Math.max(m, f) - 1);
        } else {
            return "impossible";
        }
    }

}
