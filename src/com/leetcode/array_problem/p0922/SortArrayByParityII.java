package com.leetcode.array_problem.p0922;

public class SortArrayByParityII {
    public static void main(String[] args) {

    }

    public static int[] sortArrayByParityII(int[] A) {

        int e_point = 0;
        int o_point = 0;

        int[] e_arr = new int[A.length / 2];
        int[] o_arr = new int[A.length / 2];

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                e_arr[e_point++] = A[i];
            } else {
                o_arr[o_point++] = A[i];
            }
        }

        int a_point = 0;
        for (int i = 0; i < A.length/2; i++) {
            A[a_point++] = e_arr[i];
            A[a_point++] = o_arr[i];
        }

        return A;
    }
}
