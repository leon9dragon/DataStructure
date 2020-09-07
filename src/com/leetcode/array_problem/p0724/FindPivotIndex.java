package com.leetcode.array_problem.p0724;

public class FindPivotIndex {
    public static void main(String[] args) {

    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int left = 0;
        int right = 0;
        int index;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }

        for (index = 0; index < nums.length; index++) {
            right -= nums[index];
            if (left == right) {
                return index;
            }
            left += nums[index];
        }

        return -1;
    }
}
