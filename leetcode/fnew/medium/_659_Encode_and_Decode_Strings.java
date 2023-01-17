package com.company.leetcode.fnew.medium;

import java.util.ArrayList;
import java.util.List;

public class _659_Encode_and_Decode_Strings {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("we");
        list.add("say");
        list.add(":");
        list.add("you");

        _659_Encode_and_Decode_Strings obj = new _659_Encode_and_Decode_Strings();
        System.out.println(obj.decode(obj.encode(list)));
    }


    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            int len = s.length();
            sb.append(len).append("#").append(s);
        }

        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            StringBuilder no = new StringBuilder();
            while (j < str.length() && str.charAt(j) != '#') {
                no.append(str.charAt(j));
                j++;
            }
            if (j > str.length()) {
                break;
            }
            j += 1;
            int endIndex = j + (Integer.parseInt(no.toString()));
            list.add(str.substring(j,
                    endIndex));
            i = endIndex;
        }

        return list;
    }

}
