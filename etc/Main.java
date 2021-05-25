package com.company.etc;

public class Main {

    public static void main(String[] args) {
        Main.myAtoi("20000000000000000000");
    }

    public static int myAtoi(String s) {
        String nws = s.trim();
        boolean f = false;
        int i = 0;
        if (nws.isEmpty() || nws == "" || (nws.charAt(i) != '-' && nws.charAt(i) != '+') && nws.charAt(i) < '0' || nws.charAt(i) > '9') {
            return 0;
        }
        if (nws.charAt(i) == '-' || nws.charAt(i) == '+') {
            f = (nws.charAt(i++) == '-') ? true : false;
        }
        String fs = "";
        while (i < nws.length() && nws.charAt(i) >= '0' && nws.charAt(i) <= '9') {
            fs = fs + nws.substring(i, i + 1);
            i++;
        }
        try {
            //System.out.println(fs);
            long l = Long.parseLong(fs);
            System.out.println("l = "+l);
            l = (f) ? -l : l;
            if (l > (long) Integer.MAX_VALUE) {
                l = (long) Integer.MAX_VALUE;
            }
            if (l < (long) Integer.MIN_VALUE) {
                l = (long) Integer.MIN_VALUE;
            }

            return (int) l;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
//        catch (NumberFormatException e) {
//            if (f) {
//                return Integer.MIN_VALUE;
//            } else {
//                return Integer.MAX_VALUE;
//            }
//        }

    }
}


