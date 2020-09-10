package com.leetcode.array_problem.p0832;

public class FlippingAnImage {
    public static void main(String[] args) {

    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int h_point;
        int t_point;
        int temp;
        for (int row = 0; row < A.length; row++) {
            h_point = 0;
            t_point = A[0].length - 1;
            while (h_point <= t_point) {
                if (h_point == t_point) {
                    A[row][h_point] = (A[row][h_point] + 1) % 2;
                } else {
                    temp = A[row][h_point];
                    A[row][h_point] = (A[row][t_point] + 1) % 2;
                    A[row][t_point] = (temp + 1) % 2;
                }
                h_point++;
                t_point--;
            }
        }
        return A;
    }
}
