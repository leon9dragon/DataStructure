package com.leetcode.array_problem.p0031;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 5, 3, 2};
        System.out.println("===============================");
        System.out.println("the origin array is " + Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println("the new array is" + Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int tail_pointer = nums.length - 2;
        while (tail_pointer >= 0) {
            if (nums[tail_pointer] < nums[tail_pointer + 1]) {
                break;
            }
            tail_pointer--;
        }

        if (tail_pointer == -1) {
            int h_pointer = 0;
            int t_pointer = nums.length - 1;
            int temp;
            while (h_pointer < t_pointer) {
                temp = nums[h_pointer];
                nums[h_pointer] = nums[t_pointer];
                nums[t_pointer] = temp;
                h_pointer++;
                t_pointer--;
            }
        } else {
            int temp;
            for (int i = nums.length - 1; i > tail_pointer; i--) {
                if (nums[i] > nums[tail_pointer]) {
                    temp = nums[i];
                    nums[i] = nums[tail_pointer];
                    nums[tail_pointer] = temp;
                    break;
                }
            }
            int s_pointer = tail_pointer + 1;
            int e_pointer = nums.length - 1;
            while (s_pointer < e_pointer) {
                temp = nums[s_pointer];
                nums[s_pointer] = nums[e_pointer];
                nums[e_pointer] = temp;
                s_pointer++;
                e_pointer--;
            }
        }
    }

}
