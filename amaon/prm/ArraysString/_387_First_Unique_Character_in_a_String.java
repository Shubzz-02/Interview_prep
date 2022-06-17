package com.company.amaon.prm.ArraysString;

import java.util.HashMap;
import java.util.Map;

public class _387_First_Unique_Character_in_a_String {

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(new _387_First_Unique_Character_in_a_String().firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
