package com.company.codechef.longchallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeChef3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String p = br.readLine();
            String[] point = p.trim().split(" ");
            point[0] = handle12AMCase(point[0], point[1]);
            if (point[1].equals("PM")&& !point[0].startsWith("12"))
                point[0] = to24Hours(point[0]);
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                String lr = br.readLine();
                System.out.print(chefAndMeeting(lr, point[0]));
            }
            System.out.println();
        }
    }

    private static String chefAndMeeting(String time, String p) {
        String[] lr = time.trim().split(" ");
        lr[0] = handle12AMCase(lr[0], lr[1]);
        lr[2] = handle12AMCase(lr[2], lr[3]);

        if (lr[1].equals("PM") && !lr[0].startsWith("12"))
            lr[0] = to24Hours(lr[0]);
        if (lr[3].equals("PM") && !lr[2].startsWith("12"))
            lr[2] = to24Hours(lr[2]);

        if (check(lr[0], p, 'g') && check(lr[2], p, '`'))
            return "1";
        else
            return "0";
    }

    private static boolean check(String s, String p, char c) {
        String[] hm = s.trim().split(":");
        String[] phm = p.trim().split(":");
        if (c == 'g') {
            if (Integer.parseInt(hm[0]) == Integer.parseInt(phm[0])) {
                return Integer.parseInt(hm[1]) <= Integer.parseInt(phm[1]);
            } else {
                return Integer.parseInt(hm[0]) <= Integer.parseInt(phm[0]);
            }
        } else {
            if (Integer.parseInt(hm[0]) == Integer.parseInt(phm[0])) {
                return Integer.parseInt(hm[1]) >= Integer.parseInt(phm[1]);
            } else {
                return Integer.parseInt(hm[0]) >= Integer.parseInt(phm[0]);
            }
        }
    }

    private static String to24Hours(String date) {
        String[] dd = date.trim().split(":");
        int h = Integer.parseInt(dd[0]);
        h = 12 + h;
        return h + ":" + dd[1];
    }

    private static String handle12AMCase(String time, String ap) {
        if (time.startsWith("12") && ap.equals("AM"))
            time = "00" + time.substring(2);
        return time;
    }
}
