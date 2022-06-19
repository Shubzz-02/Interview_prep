package com.company.amaon.prm.ArraysString;

import java.util.Arrays;
import java.util.Comparator;

public class _937_Reorder_Data_in_Log_Files {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig",
                "let3 art zero"};
        System.out.println(
                Arrays.toString(new _937_Reorder_Data_in_Log_Files().reorderLogFiles(logs)));
    }

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = (o1, o2) -> {
            String[] s1 = o1.trim().split(" ", 2);
            String[] s2 = o2.trim().split(" ", 2);

            boolean isDigit1 = Character.isDigit(s1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(s2[1].charAt(0));

            if (!isDigit1 && !isDigit2) {
                int cmp = s1[1].compareTo(s2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                return s1[0].compareTo(s2[0]);
            }

            if (!isDigit1 && isDigit2) {
                return -1;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else {
                return 0;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }

}
