package com.leetcode.array_problem.p0941;

public class ValidMountainArray {
    public static void main(String[] args) {

    }

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int sign = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (sign == -1) {
                    sign = 0;
                } else if (sign == 1) {
                    return false;
                }
            } else if (A[i] == A[i + 1]) {
                return false;
            } else {
                if (sign == -1) {
                    return false;
                } else if (sign == 0) {
                    sign = 1;
                }
            }
        }

        if (sign == 1) {
            return true;
        } else {
            return false;
        }
    }
}
