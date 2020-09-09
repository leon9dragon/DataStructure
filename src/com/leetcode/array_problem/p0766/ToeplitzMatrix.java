package com.leetcode.array_problem.p0766;

public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = {};
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int col = 0; col < matrix[0].length; col++) {
            int row = 1;
            int cmp = matrix[0][col];
            while (row + col < matrix[0].length) {
                if (matrix[row][row+col]!=cmp){
                    return false;
                }
            }
        }

        return true;
    }
}


