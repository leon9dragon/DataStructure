package com.leetcode.array_problem.p0189;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int k = 2;
        System.out.println("======================");
        System.out.println("origin array = " + Arrays.toString(nums));
        System.out.printf("the number of steps = [%d]\n", k);
        rotate(nums, k);
        System.out.println("rotated array = " + Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        //when k==0 and nums.length == 1, we can jump out the function
        //cuz it's meaningless to move 0 element from array's tail to head or rotate the array with 1 element
        k %= nums.length;
        if (k == 0 || nums.length == 1) return;

        //get the length of array
        int len = nums.length;

        //the index of element in array
        int index = 0;

        //define 2 temporary variables to store element's val
        int temp1 = 0;
        int temp2 = nums[index];

        //record the time of index's roll-back
        int count = index;

        //start rotating and finish it when all the elements get the new value
        for (int i = 0; i < len; i++) {
            if (index != count) {
                temp2 = temp1;
            }

            //store the new value and assign last value to new element
            temp1 = nums[(index + k) % len];
            nums[(index + k) % len] = temp2;
            //step up to next element
            index = (index + k) % len;

            //increase the index when index is rolled back to origin value
            if (index == count) {
                count++;
                index = count;
                temp2 = nums[index];
            }
        }
    }
}
