package com.leetcode.array_problem.p0016;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128, 82};
        int target = 82;
        int res = threeSumClosest(nums, target);
        System.out.println("===============================");
        System.out.println("the array is " + Arrays.toString(nums));
        System.out.printf("the res is [%d]\n", res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = 100000;
        int temp;
        int j, k;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                temp = nums[i] + nums[j] + nums[k] - target;
                if (Math.abs(diff) > Math.abs(temp)) {
                    diff = temp;
                }

                if (temp == 0) return target;
                else if (temp > 0) k--;
                else if (temp < 0) j++;
            }

        }
        return diff + target;
    }

}
