package com.leetcode.array_problem.p0039;


import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};
        int target = 6;
        List<List<Integer>> resList = combinationSum(candidates, target);
        System.out.println("=========================");
        System.out.println("the array is " + Arrays.toString(candidates));
        System.out.println("the target is [" + target + "]");
        System.out.println("\nthe combination is ");
        System.out.println(resList);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        HashSet<List<Integer>> resList = new HashSet<>();
        for (int index = 0; index < candidates.length; index++) {
            recursion(0, target, candidates[index], candidates, new ArrayList(), resList);
        }
        return new ArrayList<>(resList);
    }

    public static void recursion(int sum, int target, int num, int[] arr, ArrayList list, HashSet<List<Integer>> resList) {
        sum += num;
        list.add(num);
        if (sum == target) {
            resList.add(list);
        }
        if (sum < target) {
            for (int i = 0; i < arr.length; i++) {
                recursion(sum, target, arr[i], arr, list, resList);
            }
        }
        return;
    }
}
