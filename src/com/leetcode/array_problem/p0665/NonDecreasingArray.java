package com.leetcode.array_problem.p0665;

import java.util.Arrays;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 8};
        boolean getRes = checkPossibility(nums);
        System.out.println("===================");
        System.out.println("the array is " + Arrays.toString(nums));
        if (getRes) {
            System.out.println("Success! You can get a non-decreasing array.");
        } else {
            System.out.println("Failed! You can't get a non-decreasing array.");
        }

    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {

                if (++cnt > 1) return false;

                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }

            }
        }

        return true;
    }
}
