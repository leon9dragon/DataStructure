package com.leetcode.array_problem.p0283;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};//[4,2,4,0,0,3,0,5,1,0]
        System.out.println("=====================");
        System.out.println("the origin array = " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("the new array =    " + Arrays.toString(nums));
    }


    public static void moveZeroes(int[] nums) {
        int z_point = 0;
        while (z_point < nums.length && nums[z_point] != 0) {
            z_point++;
        }
        if (z_point >= nums.length - 1) return;

        int c_point = z_point + 1;
        while (c_point < nums.length) {
            if (nums[c_point] != 0) {
                nums[z_point] = nums[c_point];
                nums[c_point] = 0;
                z_point++;
            }
            c_point++;
        }
    }
}
