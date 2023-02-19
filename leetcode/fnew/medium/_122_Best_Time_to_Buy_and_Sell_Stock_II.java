package com.company.leetcode.fnew.medium;

import java.util.Stack;

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};
    }

    public int maxProfit(int[] prices) {


        int maxProfit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

}
