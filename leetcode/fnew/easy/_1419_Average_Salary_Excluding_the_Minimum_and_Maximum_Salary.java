package com.company.leetcode.fnew.easy;

public class _1419_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {

    public static void main(String[] args) {
        int[] arr = {4000, 3000, 1000, 2000};
        System.out.println(
                new _1419_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary().average(arr));

    }

    public double average(int[] salary) {

        int min = 0;
        int max = 0;
        double sum = salary[0];

        for (int i = 1; i < salary.length; i++) {
            if (salary[i] > salary[max]) {
                max = i;
            } else if (salary[i] < salary[min]) {
                min = i;
            }
            sum += salary[i];
        }
        sum = sum - salary[min] - salary[max];

        return (sum / (salary.length - 2));

    }
}
