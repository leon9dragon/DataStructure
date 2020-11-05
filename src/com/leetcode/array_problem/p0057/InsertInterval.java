package com.leetcode.array_problem.p0057;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 6},
                {7, 15},
                {20, 29}
        };

        int[] newInterval = new int[]{14, 30};

        int[][] res = insert(intervals, newInterval);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res;
        int n_sp;
        int n_ep = newInterval[1];

        int count = 0;
        int s_ptr = 0, e_ptr = 0;


        for (int[] row : intervals) {
            s_ptr = count;

            if (!(newInterval[0] > row[1])) {
                if (newInterval[0] <= row[0]) {
                    n_sp = newInterval[0]
                } else {
                    n_sp = row[0];
                }
                break;
            }

            count++;
        }

        if (count >= intervals.length) {
            res = new int[intervals.length + 1][];
            res[res.length - 1] = newInterval;
            for (int i = 0; i < res.length - 1; i++) {
                res[i] = intervals[i];
            }
            return res;
        }

        for (int i = s_ptr; i < intervals.length; i++) {
            e_ptr = count;

            if (!(newInterval[1]>intervals[i][1])){
                
            }
        }

    }
}
