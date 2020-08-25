package com.leetcode.array_problem.p0027;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};//{0, 1, 2, 2, 3, 0, 4, 2}
        System.out.println("========================");
        System.out.println("length of origin array = " + nums.length);
        System.out.println("origin array = " + Arrays.toString(nums));

        int target = 3;
        int res = removeElement(nums, target);
        System.out.println();
        System.out.println("the target = " + target);
        System.out.println("length of new array = " + res);
        //System.out.println("origin array = " + Arrays.toString(nums));
        System.out.printf("new array = [");
        for (int i = 0; i < res; i++) {
            if (i != res - 1) {
                System.out.printf("%d, ", nums[i]);
            } else {
                System.out.printf("%d", nums[i]);
            }
        }
        System.out.printf("]\n");
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        //define two pointer
        //one is pointed to the head of array, from head to tail
        //another is pointed to the tail of array, from tail to head
        int h_point = 0;
        int t_point = nums.length - 1;

        while (h_point < t_point) {
            if (nums[h_point] != val) {
                h_point++;
            }

            if (nums[t_point] == val) {
                t_point--;
            }

            if (nums[h_point] == val && nums[t_point] != val) {
                nums[h_point] += nums[t_point];
                nums[t_point] = nums[h_point] - nums[t_point];
                nums[h_point] -= nums[t_point];
                h_point++;
                t_point--;
            }
        }

        //the length of array equals to h_point's value + 1
        return h_point;
    }
}
