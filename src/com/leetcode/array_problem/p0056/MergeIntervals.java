package com.leetcode.array_problem.p0056;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {1, 6},
                {2, 5},
                {7, 15},
                {8, 10},
                {20, 29}
        };

        int[][] res = merge(intervals);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        //Using TreeMap to delete the intervals with same start point
        for (int i = 0; i < intervals.length; i++) {
            if (treeMap.containsKey(intervals[i][0])) {
                treeMap.put(intervals[i][0], Math.max(intervals[i][1], treeMap.get(intervals[i][0])));
            } else {
                treeMap.put(intervals[i][0], intervals[i][1]);
            }
        }

        //Merge the Interval
        int count = 0;
        int temp_key = 0;
        int temp_val = 0;
        List<List> res_list = new ArrayList<>();
        for (Integer cur_key : treeMap.keySet()) {
            if (count == 0) {
                temp_key = cur_key;
                temp_val = treeMap.get(temp_key);
                count++;
            } else {
                if (temp_val >= cur_key) {
                    temp_val = Math.max(temp_val, treeMap.get(cur_key));
                } else {
                    res_list.add(new ArrayList(Arrays.asList(temp_key, temp_val)));
                    temp_key = cur_key;
                    temp_val = treeMap.get(cur_key);
                }
            }
        }

        //Get the last interval if it's existed
        if (res_list.size() == 0 || (int) res_list.get(res_list.size() - 1).get(0) != temp_key) {
            if (!(temp_key == 0 && temp_val == 0)) {
                res_list.add(new ArrayList(Arrays.asList(temp_key, temp_val)));
            }
        }

        //Transfer list to array
        int[][] res = new int[res_list.size()][2];
        for (int i = 0; i < res_list.size(); i++) {
            res[i] = new int[]{(int) res_list.get(i).get(0), (int) res_list.get(i).get(1)};
        }
        return res;
    }
}
