package com.leetcode.array_problem.p0153;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1,0};
        int res = new FindMinimumInRotatedSortedArray().findMin(nums);
        System.out.println("min = " + res);
    }

    public int findMin(int[] nums) {
        if (nums[0] < nums[nums.length - 1]) return nums[0];

        int min = nums[nums.length - 1];

        int h_ptr = 0;
        int t_ptr = nums.length - 1;
        int m_ptr;

        while (h_ptr < t_ptr) {
            m_ptr = (h_ptr + t_ptr) / 2;
            if (nums[m_ptr] > nums[h_ptr]) {
                h_ptr = m_ptr;
            } else {
                t_ptr = m_ptr;
                min = Math.min(min, nums[m_ptr]);
            }
        }

        return min;
    }
}
