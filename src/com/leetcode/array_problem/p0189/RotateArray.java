package com.leetcode.array_problem.p0189;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;
        System.out.println("======================");
        System.out.println("origin array = " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("rotated array = " + Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (k == 0) return;
        int len = nums.length;
        int index = 0;
        int temp1 = 0;
        int temp2 = 0;
        int count = 1;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                temp1 = nums[(index + k) % len];
                nums[(index + k) % len] = nums[index];
            } else {
                temp2 = temp1;
                temp1 = nums[(index + k) % len];
                nums[(index + k) % len] = temp2;
            }
            index = (index + k) % len;

            if (index == 0) {
                index = count;
                count++;
            }
        }
    }
}
