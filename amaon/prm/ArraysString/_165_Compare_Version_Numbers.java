package com.company.amaon.prm.ArraysString;

import java.util.Arrays;
import java.util.List;

public class _165_Compare_Version_Numbers {

    public static void main(String[] args) {
        String v1 = "0.1";
        String v2 = "1.1";

        System.out.println(new _165_Compare_Version_Numbers().compareVersion(v1, v2));
    }

    public int compareVersion(String version1, String version2) {
        List<String> v1 = new java.util.ArrayList<>(Arrays.stream(version1.split("\\.")).toList());
        List<String> v2 = new java.util.ArrayList<>(Arrays.stream(version2.split("\\.")).toList());

        if (v1.size() > v2.size()) {
            while (v2.size() != v1.size()) {
                v2.add("0");
            }
        } else if (v2.size() > v1.size()) {
            while (v1.size() != v2.size()) {
                v1.add("0");
            }
        }

        int size = v1.size();
        for (int i = 0; i < size; i++) {
            if (Integer.parseInt(v1.get(i)) < Integer.parseInt(v2.get(i))) {
                return -1;
            } else if (Integer.parseInt(v1.get(i)) > Integer.parseInt(v2.get(i))) {
                return 1;
            }
        }

        return 0;
    }

}
