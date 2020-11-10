package com.leetcode.array_problem.p0057;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = new int[]{0, 2};

        int[][] res = insert(intervals, newInterval);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int s_ptr = 0;
        int e_ptr;

        int s_ifBtw = 0;
        int e_ifBtw = 0;

        int new_s = newInterval[0];
        int new_e = newInterval[1];

        for (int[] row : intervals) {
            if (newInterval[0] < row[0]) {
                new_s = newInterval[0];
                break;
            } else if (newInterval[0] >= row[0] && newInterval[0] <= row[1]) {
                s_ifBtw = 1;
                new_s = row[0];
                break;
            }
            s_ptr++;
        }

        for (e_ptr = s_ptr; e_ptr < intervals.length; e_ptr++) {
            if (newInterval[1] < intervals[e_ptr][0]) {
                new_e = newInterval[1];
                break;
            } else if (newInterval[1] >= intervals[e_ptr][0] && newInterval[1] <= intervals[e_ptr][1]) {
                e_ifBtw = 1;
                new_e = intervals[e_ptr][1];
                break;
            }
        }


        int[][] new_intervals;
        int merge_count = 0;

        //merge_count = s_ifBtw == 1 && e_ifBtw == 1 ? e_ptr - s_ptr + 1 : e_ptr - s_ptr;
        if ((s_ifBtw == 1 && e_ifBtw == 1) || (s_ifBtw == 0 && e_ifBtw == 1)) {
            merge_count = e_ptr - s_ptr + 1;
        } else {
            merge_count = e_ptr - s_ptr;
        }

        int new_length = intervals.length - merge_count + 1;

        new_intervals = new int[new_length][2];
        new_intervals[s_ptr][0] = new_s;
        new_intervals[s_ptr][1] = new_e;

        for (int i = 0; i < s_ptr; i++) {
            new_intervals[i][0] = intervals[i][0];
            new_intervals[i][1] = intervals[i][1];
        }

        int ptr = e_ifBtw == 1 ? e_ptr + 1 : e_ptr;
        for (int i = s_ptr + 1; i < new_intervals.length && ptr < intervals.length; i++, ptr++) {
            new_intervals[i][0] = intervals[ptr][0];
            new_intervals[i][1] = intervals[ptr][1];
        }

        return new_intervals;
    }
}
