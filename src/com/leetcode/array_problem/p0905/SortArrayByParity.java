package com.leetcode.array_problem.p0905;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {

    }

    public static int[] sortArrayByParity(int[] A) {
        Arrays.sort(A);
        ArrayList<Integer> even_list = new ArrayList<>();
        ArrayList<Integer> odd_list = new ArrayList<>();
        for (int index = 0; index < A.length; index++) {
            if (A[index] % 2 == 0) {
                even_list.add(A[index]);
            } else {
                odd_list.add(A[index]);
            }
        }

        even_list.addAll(odd_list);

        for (int index = 0; index < even_list.size(); index++) {
            A[index] = even_list.get(index);
        }
        return A;
    }
}
