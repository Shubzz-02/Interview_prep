package com.company.etc;

import java.util.Locale;

public class PalindromeString {
    public static void main(String[] args) {
        System.out.println(replaceAll( "This#string%con_tains^special*characters&."));
    }

    public static String replaceAll(String s){
        return s.replaceAll("[^a-zA-Z0-9]","").toLowerCase(Locale.ROOT);
    }
}
