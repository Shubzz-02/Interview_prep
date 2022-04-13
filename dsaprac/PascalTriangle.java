package com.company.dsaprac;


import com.company.annotation.Question;
import com.company.annotation.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(question = "Pascal's Triangle", link = "https://leetcode.com/problems/pascals-triangle/")
public class PascalTriangle {


    public static void main(String[] args) {
        List<List<Integer>> res = new PascalTriangle().generate(5);
        for (List<Integer> i : res) {
            System.out.println(Arrays.asList(i.toArray()));
        }
    }

    @Solution(no = 1, timeComp = "O(numRows^2)", spaceComp = "O(numRows^2)")
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < i + 1 ; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
        }
        return result;
    }
}
