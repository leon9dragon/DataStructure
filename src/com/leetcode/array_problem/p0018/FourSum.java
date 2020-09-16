package com.leetcode.array_problem.p0018;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> res = new ArrayList<>();
        res = fourSum(nums,1);
        System.out.println(res);

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) return new ArrayList<>(); // if nums less than 4 element
        Arrays.sort(nums); // sort array
        Set<List<Integer>> set = new HashSet<>();
        int j, k, sum;
        for (int h = 0; h < nums.length - 3; h++) {
            for (int i = h + 1; i < nums.length - 2; i++) {
                j = i + 1;
                k = nums.length - 1;
                while (j < k) {
                    sum = nums[h] + nums[i] + nums[j] + nums[k];
                    if (sum == target) set.add(Arrays.asList(nums[h], nums[i], nums[j++], nums[k--]));
                    else if (sum > target) k--;
                    else if (sum < target) j++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
