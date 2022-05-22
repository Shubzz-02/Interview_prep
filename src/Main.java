package com.company.src;


import java.util.*;
import java.io.*;

public class Main {
    public static Map<String, Integer> processData(ArrayList<String[]> array) {
        Map<String, Integer> data = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (String[] line : array) {
            Integer list = Integer.parseInt(line[0].trim());
            if (data.containsKey(line[2].trim())) {
                if (data.get(line[2].trim()) < list) {
                    data.put(line[2].trim(), list);
                    set.remove(data.get(line[2].trim()));
                    set.add(list);
                }
            } else {
                data.put(line[2].trim(), list);
                set.add(list);
            }
        }

        Map<String, Integer> retVal = new HashMap<>();
        for (String[] line : array) {
            if (set.contains(Integer.parseInt(line[0].trim()))) {
                retVal.put(line[2].trim(), Integer.parseInt(line[3].trim()));
            }
        }
        return retVal;
    }

    public static void main(String[] args) {
        ArrayList<String[]> inputData = new ArrayList<>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            while (in.hasNextLine())
                inputData.add(in.nextLine().trim().split(","));
            Map<String, Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            for (Map.Entry<String, Integer> e : retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt " + e.getMessage());
        }
    }
}
