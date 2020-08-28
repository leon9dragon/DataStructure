package com.leetcode.array_problem.p0169;

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        
    }
}
