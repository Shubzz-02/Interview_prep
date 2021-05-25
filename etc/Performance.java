package com.company.etc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Performance {
    public static void main(String[] args) throws IOException {
        File fr = new File("C:\\Users\\Shubzz\\Desktop\\Signal Stuff\\TT\\src\\com\\company\\etc\\a.in");
        NumberFormat formatter = new DecimalFormat("#0.00000");
        Scanner myReader = new Scanner(fr);
        int ct = 0;
        int[] arr = new int[10000];
        while (myReader.hasNextLine()) {
            int data = myReader.nextInt();
            arr[ct++] = data;
        }
        long start = System.currentTimeMillis();
        readFileBuff();
        long end = System.currentTimeMillis();

        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

        start = System.currentTimeMillis();
        readFileBuffF();
        end = System.currentTimeMillis();

        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");

        start = System.currentTimeMillis();
        readFileScanner();
        end = System.currentTimeMillis();

        System.out.println("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");


    }

    public static void readFileBuff() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Shubzz\\Desktop\\Signal Stuff\\TT\\src\\com\\company\\etc\\a.in"));
        String strCurrentLine;
        int[] arr = new int[10000];
        while ((strCurrentLine = reader.readLine()) != null) {
            arr = Arrays.stream(strCurrentLine.trim().split(" ")).parallel().mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void readFileBuffF() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Shubzz\\Desktop\\Signal Stuff\\TT\\src\\com\\company\\etc\\a.in"));
        String strCurrentLine;
        int[] arr = new int[10000];
        int ct = 0;
        while ((strCurrentLine = reader.readLine()) != null) {
            arr[ct++] = Integer.parseInt(strCurrentLine);
        }
    }

    public static void readFileScanner() throws IOException {
        File fr = new File("C:\\Users\\Shubzz\\Desktop\\Signal Stuff\\TT\\src\\com\\company\\etc\\a.in");
        Scanner myReader = new Scanner(fr);
        int ct = 0;
        int[] arr = new int[10000];
        while (myReader.hasNextLine()) {
            int data = myReader.nextInt();
            arr[ct++] = data;
        }
    }

    public static int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).parallel().filter(i -> ((int) (Math.floor(Math.log10(i)) + 1) % 2) == 0).count();
    }



    public static int findNumbersL(int[] nums) {
        int count = 0;
        int evenNumber = 0;
        for (int i = 0; i < nums.length; ++i) {
            int number = nums[i];
            count = 0;
            while (number > 0) {
                number = number / 10;
                ++count;
            }
            if (count % 2 == 0) {
                evenNumber += 1;
            }
        }
        return evenNumber;
    }

}


//    long start = System.currentTimeMillis();
//
//
//        long end = System.currentTimeMillis();
//
//        NumberFormat formatter = new DecimalFormat("#0.00000");
//        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
