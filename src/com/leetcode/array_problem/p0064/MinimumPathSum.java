package com.leetcode.array_problem.p0064;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int getMinPath = minPathSum(grid);
        System.out.printf("The min path sum is [%d].", getMinPath);
    }

    public static int minPathSum(int[][] grid) {
        //init the first row
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        //init the first col
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        //get the other result, all the elements' val are the min path to their point.
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        //return the last element
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
