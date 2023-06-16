package com.company.neetcode;

public class Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        System.out.println(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(prices));
    }


    public int maxProfit(int[] prices) {

        int l = 0, r = 1;

        int max = 0;
        while (r < prices.length) {
            max = Math.max(max, prices[r] - prices[l]);

            if (prices[r] < prices[l]) {
                l = r;
            }
            r++;
        }
        return max;
    }

    public int maxProfitBF(int[] prices) {

        int max = 0;
        int l = 0, r = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    l = i;
                    r = j;
                }
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        System.out.println(l + " " + r);
        return max;
    }
}
