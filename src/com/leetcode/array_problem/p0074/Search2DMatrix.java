package com.leetcode.array_problem.p0074;

import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 2;

        boolean res = searchMatrix(matrix, target);
        System.out.println(res);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int R = matrix.length;
        int C = matrix[0].length;

        if (target < matrix[0][0] || target > matrix[R - 1][C - 1]) {
            return false;
        }

        if (target == matrix[0][0] || target == matrix[R - 1][C - 1]) {
            return true;
        }

        int res;

        int t_ptr = R;
        int h_ptr = 0;
        int mid = (t_ptr + h_ptr) / 2;
        while (t_ptr - h_ptr > 1) {
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) t_ptr = mid;
            else h_ptr = mid;
            mid = (t_ptr + h_ptr) / 2;
        }

        res = Arrays.binarySearch(matrix[h_ptr], target);

        return res > 0;
    }
}
