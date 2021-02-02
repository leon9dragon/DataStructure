package com.leetcode.hashtable_problem.p0136;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {

    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> hash_table = new HashMap<>();
        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
