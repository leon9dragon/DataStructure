package com.leetcode.array_problem.p0268;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println("========================");
        int[] nums = {4, 0, 2, 5, 1, 3, 6};
        System.out.println("the origin array = " + Arrays.toString(nums));
        int res = missingNumber(nums);
        System.out.println("the sorted array = " + Arrays.toString(nums));
        System.out.printf("the missing number = [%d]\n", res);
    }

    public static int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
