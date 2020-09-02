package com.leetcode.array_problem.p0448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedInArray {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> getList = new ArrayList<Integer>();
        System.out.println("======================");
        System.out.println("the origin array = " + Arrays.toString(nums));
        getList = findDisappearedNumbers(nums);
        System.out.println("the edited array = " + Arrays.toString(nums));
        System.out.println("the disappeared numbers = " + getList);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resList = new ArrayList<Integer>();
        int index;
        for (int i = 0; i < nums.length; i++) {
            index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                resList.add(i + 1);
            }
        }

        return resList;
    }
}
