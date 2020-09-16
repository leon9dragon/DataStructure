package com.leetcode.array_problem.p0033;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int getRes = search(nums, target);
        System.out.println(getRes);
    }

    public static int search(int[] nums, int target) {
        if (target < nums[0] && target > nums[nums.length - 1]) return -1;

        int first_ptr = 0;
        int last_ptr = nums.length - 1;
        int mid_ptr;

        while (first_ptr <= last_ptr && first_ptr < nums.length && last_ptr >= 0) {
            if (target == nums[0]) return 0;
            if (target == nums[nums.length - 1]) return nums.length - 1;

            mid_ptr = (first_ptr + last_ptr) / 2;
            if (target == nums[mid_ptr]) return mid_ptr;

            if (target > nums[mid_ptr]) {
                if(target<nums[last_ptr]){
                    
                }
            } else {

            }

        }

        return -1;
    }
}
