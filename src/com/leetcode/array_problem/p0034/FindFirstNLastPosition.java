package com.leetcode.array_problem.p0034;

import java.util.Arrays;

public class FindFirstNLastPosition {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 1;
        int[] index = searchRange(nums, target);
        System.out.println("========================");
        System.out.println("the array is " + Arrays.toString(nums));
        System.out.println("the target is [" + target + "]");
        System.out.println("the index of target is " + Arrays.toString(index));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] index = {-1, -1};
        if (nums.length == 0) return index;
        binarySearch(nums, target, 0, nums.length - 1, index);
        return index;
    }


    public static void binarySearch(int[] nums, int target, int head, int tail, int[] index) {
        int mid;
        while (head < tail) {
            mid = (head + tail) / 2;
            if (nums[mid] == target) {
                if (index[0] == -1) {
                    index[0] = mid;
                    index[1] = mid;
                }
                if (mid < index[0]) {
                    index[0] = mid;
                }
                if (mid > index[1]) {
                    index[1] = mid;
                }
                binarySearch(nums, target, head, mid - 1, index);
                binarySearch(nums, target, mid + 1, tail, index);
                break;
            }
            if (nums[mid] > target) {
                tail = mid - 1;
            }
            if (nums[mid] < target) {
                head = mid + 1;
            }
        }

        if (nums[head] == target) {
            if (index[0] == -1) {
                index[0] = head;
                index[1] = head;
            }
            if (head < index[0]) {
                index[0] = head;
            }
            if (head > index[1]) {
                index[1] = head;
            }
        }
    }
}
