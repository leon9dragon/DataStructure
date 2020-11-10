package com.leetcode.array_problem.p0063;

public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] grid = new int[m][n];

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) break;
            else grid[0][i] = 1;
        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) break;
            else grid[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = (grid[i][j - 1] + grid[i - 1][j]) * ((obstacleGrid[i][j] + 1) % 2);
            }
        }
        return grid[m - 1][n - 1];
    }
}
