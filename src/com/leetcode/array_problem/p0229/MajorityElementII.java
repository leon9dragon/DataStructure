package com.leetcode.array_problem.p0229;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {

    }

    public List<Integer> majorityElement(int[] nums) {
        // We can only have maximum 2 majority elements

        int n = nums.length;
        int count1 = 0, count2 = 0;
        Integer major1 = null, major2 = null;

        // step 1. Find out those 2 majority elements
        // Using Moore majority voting algorithm
        for (int i = 0; i < n; i++) {
            if (major1 != null && nums[i] == major1) {
                count1++;
            } else if (major2 != null && nums[i] == major2) {
                count2++;
            } else if (count1 == 0) {
                major1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                major2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2. Double Check

        //The first round only elects two most frequent numbers as candidates; there is no guarantee that the candidates appear more than N/3 times.
        //Try out this example: [1,1,1,2,3,3] where 1 and 3 are both candidates but only 1 appears more than N/3=2 times.

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (major1 != null && nums[i] == major1) count1++;
            if (major2 != null && nums[i] == major2) count2++;
        }

        List<Integer> res = new ArrayList<Integer>();

        if (count1 > n / 3) res.add(major1);
        if (count2 > n / 3) res.add(major2);

        return res;
    }
}
