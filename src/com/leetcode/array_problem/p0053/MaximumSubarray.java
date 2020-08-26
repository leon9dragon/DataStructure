package com.leetcode.array_problem.p0053;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubArray(nums);
        System.out.println("======================");
        System.out.println("the array = " + Arrays.toString(nums));
        System.out.println("the largest sum = " + res);
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        return max;
    }

}
