package com.leetcode.array_problem.p0977;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n_ptr = 0;
        int p_ptr = nums.length - 1;
        int[] ret = new int[nums.length];
        int index = nums.length - 1;
        while (n_ptr <= p_ptr && index >= 0) {
            if (nums[n_ptr] < 0) {
                if (-nums[n_ptr] > nums[p_ptr]) ret[index--] = nums[n_ptr] * nums[n_ptr++];
                else ret[index--] = nums[p_ptr] * nums[p_ptr--];
            } else ret[index--] = nums[p_ptr] * nums[p_ptr--];
        }
        return ret;
    }
}
