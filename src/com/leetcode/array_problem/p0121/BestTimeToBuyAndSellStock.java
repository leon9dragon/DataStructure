package com.leetcode.array_problem.p0121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        int getProfit = maxProfit(prices);
        System.out.println("==================");
        System.out.println("the prices array = " + Arrays.toString(prices));
        if (getProfit != 0) {
            System.out.printf("the max profit = [%d]\n", getProfit);
        } else {
            System.out.println("No transaction is done!");
        }
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
