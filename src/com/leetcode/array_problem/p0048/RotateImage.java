package com.leetcode.array_problem.p0048;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int h_ptr = 0, t_ptr = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            while (h_ptr < t_ptr) {
                temp = matrix[i][h_ptr];
                matrix[i][h_ptr] = matrix[i][t_ptr];
                matrix[i][t_ptr] = temp;
                h_ptr++;
                t_ptr--;
            }
        }
    }
}
