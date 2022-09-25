package com.company.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Magical_Binary_String {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String binaryString = br.readLine();
            System.out.println(ifMagicalBinaryString(binaryString));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean ifMagicalBinaryString(String binaryString) {
        int[] total = count01(binaryString);

        if(total[0] == total[1]){
            for (int i = 0; i < binaryString.length(); i++) {
                for (int j = i+1; j < binaryString.length()-1; j++) {
                    total = count01(binaryString.substring(i,j));
                    if(total[0] > total[1])
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    private static int[] count01(String binaryString) {
        int[] t = new int[2];

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '0') {
                t[0]++;
            } else {
                t[1]++;
            }
        }
        return t;
    }


}
