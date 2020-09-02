package com.leetcode.array_problem.p0414;

import java.util.Arrays;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.println("===============");
        System.out.println("The array = " + Arrays.toString(nums));
        thirdMax(nums);
    }

    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int getMax = nums[0];
        int getSecond = nums[0];
        int getThird = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (getMax < nums[i]) {
                getThird = getSecond;
                getSecond = getMax;
                getMax = nums[i];
            }
        }

        if (getThird != getSecond) {
            System.out.printf("The third maximum is [%d]\n", getThird);
            return getThird;
        } else {
            System.out.printf("The third maximum is not existed! The maximum is [%d]\n", getThird);
            return getMax;
        }

        /** Another Approach by using TreeSet
         *
         * TreeSet<Integer> treeSet = new TreeSet<>();
         *         Arrays.stream(nums).forEach(treeSet::add);
         *
         *         if (treeSet.size() > 2) {
         *             treeSet.pollLast();
         *             treeSet.pollLast();
         *         }
         *         return treeSet.pollLast();
         *
         * */
    }
}
