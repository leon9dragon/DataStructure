package com.leetcode.array_problem.p0057;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {1, 6},
                {2, 5},
                {7, 15},
                {8, 10},
                {20, 29}
        };

        int[][] res = insert(intervals, new int[]{21, 70});
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        //Using TreeMap to delete the intervals with same start point
        for (int i = 0; i <= intervals.length; i++) {
            //This part is using to add the origin intervals to TreeMap
            if (i != intervals.length) {
                treeMap.put(intervals[i][0], intervals[i][1]);
            }
            //This part is using to add the new interval to TreeMap
            else {
                if (treeMap.containsKey(newInterval[0])) {
                    treeMap.put(newInterval[0], Math.max(newInterval[1], treeMap.get(newInterval[0])));
                } else {
                    treeMap.put(newInterval[0], newInterval[1]);
                }
            }
        }


    }
}
