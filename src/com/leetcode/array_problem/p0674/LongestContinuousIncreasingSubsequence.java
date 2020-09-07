package com.leetcode.array_problem.p0674;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7, 8, 9, 9, 9, 9, 9, 9};
        int getRes = findLengthOfLCIS(nums);
        System.out.println("=======================");
        System.out.println("the array is " + Arrays.toString(nums));
        System.out.printf("the length of CIS is [%d]\n", getRes);
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        int max = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
