package com.leetcode.array_problem.p0088;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        System.out.println("origin nums1 = " + Arrays.toString(nums1));
        System.out.println("origin nums2 = " + Arrays.toString(nums2));
        merge(nums1, 0, nums2, nums2.length);
        System.out.println("new nums1 = " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //merge two arrays
        if (m == 0 && n == 0) {
            return;
        } else if (m == 0 && n != 0) {
            nums1 = nums2;
        } else {
            for (int i = 0; i < n; i++) {
                nums1[n + i] = nums2[i];
            }
        }
        //use quick sort to deal with it
        quickSort(nums1, 0, nums1.length - 1);
    }

    public static void quickSort(int[] nums, int head, int tail) {
        int h_point = head;
        int t_point = tail;

        int mid_key = (h_point + t_point) / 2;

        while (h_point < t_point) {
            while (nums[h_point] < nums[mid_key]) {
                h_point++;
            }

            while (nums[t_point] > nums[mid_key]) {
                t_point--;
            }

            if (h_point == t_point) {
                break;
            } else {
                nums[h_point] += nums[t_point];
                nums[t_point] = nums[h_point] - nums[t_point];
                nums[h_point] -= nums[t_point];
            }
        }

        if (h_point < tail) {
            quickSort(nums, h_point + 1, tail);
        }

        if (t_point > head) {
            quickSort(nums, head, t_point - 1);
        }
    }
}
