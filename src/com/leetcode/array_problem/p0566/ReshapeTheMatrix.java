package com.leetcode.array_problem.p0566;

import java.util.Arrays;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int[][] res = matrixReshape(nums, 1, 4);
        System.out.println("===================");
        System.out.println("=========the origin matrix=========");
        for(int[] row: nums){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("=========the reshape matrix=========");
        for(int[] row: res){
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n_col = nums[0].length;

        if (nums.length * n_col != r * c) return nums;

        int[][] res = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / n_col][i % n_col];
        }

        return res;
    }
}
