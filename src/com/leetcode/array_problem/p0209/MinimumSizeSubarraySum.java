package com.leetcode.array_problem.p0209;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {

    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int start = 0, end = 0, sum = 0,
                min = Integer.MAX_VALUE;

        while (end < nums.length) {
            sum += nums[end];

            //optimize the array
            while (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
