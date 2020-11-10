package com.leetcode.array_problem.p0062;

public class UniquePaths {
    public static void main(String[] args) {
        int res = uniquePaths(51, 9);
        System.out.printf("There are [%d] unique paths!", res);
    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
            }
        }
        return grid[m - 1][n - 1];
    }

}
