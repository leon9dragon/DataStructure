package com.leetcode.array_problem.p0766;

import java.util.Arrays;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2},
                {0, 9, 5, 1}
        };
        boolean res = isToeplitzMatrix(matrix);
        System.out.println("==============================");
        System.out.println("the matrix is ");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.printf("\nthe result is [%b]\n", res);
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[row - 1][col - 1] != matrix[row][col]) return false;
            }
        }
        return true;
    }


}


