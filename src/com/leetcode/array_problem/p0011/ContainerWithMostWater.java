package com.leetcode.array_problem.p0011;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int max = maxArea(height);
        System.out.println("===========================");
        System.out.println("the array is " + Arrays.toString(height));
        System.out.printf("the max area is [%d]\n", max);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int product = 0;
        int h_point = 0;
        int t_point = height.length - 1;
        while (h_point < height.length) {
            while (t_point >= 0) {
                product = (t_point - h_point) * (Math.min(height[h_point], height[t_point]));
                max = Math.max(max, product);
                t_point--;
            }
            h_point++;
            t_point = height.length - 1;
        }

        return max;
    }
}
