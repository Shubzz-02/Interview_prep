package com.company.amaon.recursion1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ReverseString {
    public static void main(String[] args) throws ParseException {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new SolutionReverseString().reverseString(s);
        System.out.println(Arrays.toString(s));
        System.out.println(new SolutionReverseString().compare());
    }
}


class SolutionReverseString {

    public int compare() throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("27/11/1993");
        Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("12/06/1993");
        return date2.compareTo(date1);
    }

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            s[i] = (char) (s[i] ^ s[j] ^ (s[j] = s[i]));
            i++;
            j--;
        }
    }

}
