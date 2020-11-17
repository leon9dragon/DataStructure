package com.leetcode.array_problem.p0120;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (List<Integer> list : triangle) {
            for (int i = 0; i < list.size(); i++) {
                min = Math.min(min, list.get(i));
            }
            sum += min;
            min = Integer.MAX_VALUE;
        }

        return sum;
    }
}
