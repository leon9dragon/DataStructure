package com.leetcode.array_problem.p0059;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 4;
        int[][] res = generateMatrix(n);

        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][];
        }

        int[][] res = new int[n][n];

        int r_change = n;
        int c_change = n - 1;

        int r_ptr = 0;
        int c_ptr = -1;

        int ele_count = n * n;
        int cur_case = 0;

        int all_count = n * n;
        int temp_change;

        while (ele_count > 0) {
            switch (cur_case % 4) {
                case 0:
                    temp_change = r_change;
                    while (temp_change > 0) {
                        temp_change--;
                        ele_count--;
                        c_ptr++;
                        res[r_ptr][c_ptr] = all_count - ele_count;
                    }
                    r_change--;
                    cur_case++;
                case 1:
                    temp_change = c_change;
                    while (temp_change > 0) {
                        temp_change--;
                        ele_count--;
                        r_ptr++;
                        res[r_ptr][c_ptr] = all_count - ele_count;
                    }
                    c_change--;
                    cur_case++;
                case 2:
                    temp_change = r_change;
                    while (temp_change > 0) {
                        temp_change--;
                        ele_count--;
                        c_ptr--;
                        res[r_ptr][c_ptr] = all_count - ele_count;
                    }
                    r_change--;
                    cur_case++;
                case 3:
                    temp_change = c_change;
                    while (temp_change > 0) {
                        temp_change--;
                        ele_count--;
                        r_ptr--;
                        res[r_ptr][c_ptr] = all_count - ele_count;
                    }
                    c_change--;
                    cur_case++;
            }
        }

        return res;
    }
}
