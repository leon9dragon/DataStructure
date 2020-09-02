package com.leetcode.array_problem.p0485;

import java.util.Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 0, 0, 1, 1, 1, 1, 0};//0, 0, 1, 0, 0, 1, 1, 1, 1, 0
        System.out.println("======================");
        System.out.println("the array = " + Arrays.toString(nums));
        int getRes = findMaxConsecutiveOnes(nums);
        System.out.printf("the max consecutive ones = [%d]\n", getRes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }
}
