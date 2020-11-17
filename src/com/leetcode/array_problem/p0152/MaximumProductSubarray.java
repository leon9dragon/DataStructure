package com.leetcode.array_problem.p0152;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, 5};
        int res = new MaximumProductSubarray().maxProduct(nums);
        System.out.println("res = " + res);
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int ans = nums[0], min = ans, max = ans;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                int tmp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], tmp * nums[i]);
            }

            ans = Math.max(ans, max);
        }

        return ans;
    }
}
