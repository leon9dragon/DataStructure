package com.leetcode.array_problem.p0055;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4};
        System.out.println(canJump(nums));
    }


    public static boolean canJump(int[] nums) {
        if (nums.length == 0) return false;

        int ele_ptr = nums.length - 1;
        int g_ptr = nums.length - 1;
        int[] status_arr = new int[nums.length];

        while (ele_ptr >= 0) {
            if ((nums[ele_ptr] + ele_ptr) >= g_ptr) {
                status_arr[ele_ptr] = 1;
                g_ptr = ele_ptr;
            }
            ele_ptr--;
        }

        return (status_arr[0] == 1);
    }


}
