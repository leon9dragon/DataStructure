package com.leetcode.array_problem.p0121;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        int getProfit = maxProfit(prices);
        System.out.println("==================");
        System.out.println("the prices array = " + Arrays.toString(prices));
        if(getProfit!=0){
            System.out.printf("the max profit = [%d]\n", getProfit);
        }else {
            System.out.println("No transaction is done!");
        }
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                maxProfit = Math.max(maxProfit, prices[i] - prices[j]);
            }
        }
        if (maxProfit <= 0) {
            return 0;
        }
        return maxProfit;
    }
}
