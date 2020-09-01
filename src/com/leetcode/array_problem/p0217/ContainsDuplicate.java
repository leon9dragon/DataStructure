package com.leetcode.array_problem.p0217;

import java.util.Arrays;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println("========================");
        System.out.println("the array = " + Arrays.toString(nums));
        boolean res = containsDuplicate(nums);
        System.out.printf("the result is [%b]\n", res);
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }
}
