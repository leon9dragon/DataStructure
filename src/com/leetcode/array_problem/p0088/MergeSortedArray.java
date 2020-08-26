package com.leetcode.array_problem.p0088;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        System.out.println("origin nums1 = " + Arrays.toString(nums1));
        System.out.println("origin nums2 = " + Arrays.toString(nums2));
        merge(nums1, 3, nums2, 3);
        System.out.println("new nums1 = " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //merge two arrays
        if (m == 0 && n == 0) {
            return;
        } else if (m == 0 && n != 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
        }
        //use quick sort to deal with it
        sort(nums1, 0, m + n - 1);
    }

    public static void sort(int arr[], int low, int high) {
        int start = low;
        int end = high;
        int key = arr[low];
        while (end > start) {
            while (end > start && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (end > start && arr[start] <= key) {
                start++;
            }
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if (start > low) {
            sort(arr, low, start - 1);
        }
        if (end < high) {
            sort(arr, end + 1, high);
        }
    }
}
