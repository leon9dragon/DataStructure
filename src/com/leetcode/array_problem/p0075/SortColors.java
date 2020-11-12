package com.leetcode.array_problem.p0075;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 0, 2, 2, 1, 0, 1, 2, 0, 2};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if (nums.length == 1) return;
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) red++;
            else if (nums[i] == 1) white++;
            else blue++;
        }
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < white; i++) {
            nums[red + i] = 1;
        }
        for (int i = 0; i < blue; i++) {
            nums[red + white + i] = 2;
        }
    }
}
