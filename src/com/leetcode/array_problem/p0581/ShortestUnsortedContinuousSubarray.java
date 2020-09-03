package com.leetcode.array_problem.p0581;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {6,6,1,2,3,1,4,5};//2, 6, 4, 8, 10, 9, 15
        int getRes = findUnsortedSubarray(nums);
        System.out.println("==================");
        System.out.println("the array = " + Arrays.toString(nums));
        System.out.printf("the length of subarray is [%d]\n", getRes);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);
        int head = -1;
        int tail = -1;
        for (int i = 0; i < nums.length; i++) {
            if (head == -1) {
                if (sorted_nums[i] != nums[i]) {
                    head = i;
                }
            }

            if (tail == -1) {
                if (sorted_nums[nums.length - 1 - i] != nums[nums.length - 1 - i]) {
                    tail = nums.length - 1 - i;
                }
            }
            if (tail != -1 && head != -1) break;
        }

        if (head == tail) return 0;
        return tail - head + 1;
    }
}
