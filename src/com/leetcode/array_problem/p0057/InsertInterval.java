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
        int new_sp = newInterval[0];
        int new_ep = newInterval[1];

        

        for (int[] row : intervals) {

        }


    }
}
