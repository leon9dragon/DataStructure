package com.leetcode.array_problem.p0985;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ret = new int[A.length];
        int sum = 0;
        int len = A.length;
        for (int j = 0; j < len; j++) if (A[j] % 2 == 0) sum += A[j];
        int dummy = 0;
        for (int i = 0; i < len; i++) {
            dummy = A[queries[i][1]] + queries[i][0];
            if (A[queries[i][1]] % 2 == 0) {
                if (dummy % 2 != 0) sum -= A[queries[i][1]];
                else sum += queries[i][0];
            } else {
                if (dummy % 2 == 0) sum += dummy;
            }
            ret[i] = sum;
            A[queries[i][1]] = dummy;
        }
        return ret;
    }
}
