package com.leetcode.array_problem.p0054;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] test = {
                {1, 2, 3, 4}
        };
        List<Integer> resList = spiralOrder(test);
        System.out.println(resList);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();

        if (matrix.length == 0) return resList;

        int row_ptr = 0;
        int col_ptr = 0;

        int row_ul = matrix[0].length;
        int col_ul = matrix.length - 1;
        int count = 0;

        int round = 0;
        int ele_count = matrix.length * matrix[0].length;


        while (ele_count > 0) {
            switch (round % 4) {
                case 0:
                    while (count < row_ul) {
                        resList.add(matrix[row_ptr][col_ptr]);
                        col_ptr++;
                        count++;
                    }
                    ele_count -= row_ul;
                    col_ptr--;
                    row_ptr++;
                    row_ul--;
                    count = 0;
                    round++;
                    break;
                case 1:
                    while (count < col_ul) {
                        resList.add(matrix[row_ptr][col_ptr]);
                        row_ptr++;
                        count++;
                    }
                    ele_count -= col_ul;
                    row_ptr--;
                    col_ptr--;
                    col_ul--;
                    count = 0;
                    round++;
                    break;
                case 2:
                    while (count < row_ul) {
                        resList.add(matrix[row_ptr][col_ptr]);
                        col_ptr--;
                        count++;
                    }
                    ele_count -= row_ul;
                    col_ptr++;
                    row_ptr--;
                    row_ul--;
                    count = 0;
                    round++;
                    break;
                case 3:
                    while (count < col_ul) {
                        resList.add(matrix[row_ptr][col_ptr]);
                        row_ptr--;
                        count++;
                    }
                    ele_count -= col_ul;
                    row_ptr++;
                    col_ptr++;
                    col_ul--;
                    count = 0;
                    round++;
                    break;
            }
        }

        return resList;
    }
}
