package com.leetcode.array_problem.p0896;

public class MonotonicArray {
    public static void main(String[] args) {

    }

    public static boolean isMonotonic(int[] A) {
        int last_sign = 0;
        int curr_sign = 0;
        for (int index = 0; index < A.length - 1; index++) {
            if (A[index] > A[index + 1]) {
                curr_sign = 1;
            } else if (A[index] < A[index + 1]) {
                curr_sign = -1;
            }

            if (last_sign == 0) {
                last_sign = curr_sign;
            } else {
                if (last_sign != curr_sign) {
                    return false;
                }
            }
        }
        return true;
    }
}
