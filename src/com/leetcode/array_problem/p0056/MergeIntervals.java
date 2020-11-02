package com.leetcode.array_problem.p0056;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                { 1, 3},
                { 2, 6},
                { 0,10},
                {15,18}
        };
        merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0], intervals[i][1]);
        }

        System.out.println(treeMap);

        return new int[0][];
    }
}
