package com.leetcode.array_problem.p0905;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {

    }

    public static int[] sortArrayByParity(int[] A) {
        Arrays.sort(A);
        int[] B = new int[A.length];
        int h_pointer = 0;
        int t_pointer = A.length - 1;
        for (int index = 0; index < A.length; index++) {
            if (A[index] % 2 == 0) {
                B[h_pointer] = A[index];
                h_pointer++;
            }else {
                B[t_pointer] = A[index];
                t_pointer--;
            }
        }
        return B;
    }
}
