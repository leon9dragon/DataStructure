package com.leetcode.array_problem.p0055;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }


    public static boolean canJump(int[] nums) {
        int cur_index = 0;
        return recursion(nums, cur_index);
    }

    public static boolean recursion(int[] nums, int cur_index) {
        int step = nums[cur_index];

        if (cur_index + step >= nums.length - 1) {
            return true;
        }

        while (step > 0) {
            if(recursion(nums, cur_index + step)) return true;
            step--;
        }

        return false;
    }

}
