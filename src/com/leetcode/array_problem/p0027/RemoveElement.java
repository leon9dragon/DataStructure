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
        //another is pointed to the tail of array, which is equals to array's length
        int pointer = 0;
        int length = nums.length;

        //so the pointer should be less than array's length to avoid being out of bound
        while (pointer < length) {
            //when we find a duplicate the length sub 1
            if (nums[pointer] == val) {
                nums[pointer] = nums[length - 1];
                length--;
            } else {
                pointer++;
            }
        }
        return length;
    }
}
