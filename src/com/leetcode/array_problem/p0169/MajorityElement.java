package com.leetcode.array_problem.p0169;

import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int getMajor = majorityElement(nums);
        System.out.println("======================");
        System.out.println("the target array = " + Arrays.toString(nums));
        System.out.printf("the major element = [%d]", getMajor);
    }

    public static int majorityElement(int[] nums) {
        //get the counts of every element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<Integer> val_list = new ArrayList<Integer>(map.values());
        val_list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return v1 - v2;
            }
        });

        //define the max value and key
        int maxVal = val_list.get(val_list.size() - 1);
        int maxKey = 0;

        //loop through the map tp find the key fo the maxVal
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) {
                maxKey = entry.getKey();
            }
        }

        //return the majority element
        return maxKey;
    }
}
