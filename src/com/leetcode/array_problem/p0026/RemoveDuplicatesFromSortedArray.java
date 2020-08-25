package com.leetcode.array_problem.p0026;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println("========================");
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 5, 20};
        System.out.println("length of origin array = " + nums.length);
        System.out.println("origin array = " + Arrays.toString(nums));
        int res = removeDuplicates(nums);
        System.out.println();
        System.out.println("length of new array = " + res);
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

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        //define two pointers for loop through the array
        //one is pointer for duplicates, another pointer is just for point to array's elements
        int d_point = 0;
        int e_point = 1;

        //the e_point should not be out of the array's bound,
        //therefore we should end the loop when it's out of bound
        while (e_point < nums.length) {
            if (nums[e_point] != nums[d_point]) {
                nums[++d_point] = nums[e_point];
            }
            e_point++;
        }
        //the length of array is the indice which is d_point add 1
        return d_point + 1;
    }
}
