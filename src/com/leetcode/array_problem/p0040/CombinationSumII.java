package com.leetcode.array_problem.p0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};
        int target = 6;
        List<List<Integer>> resList = combinationSum2(candidates, target);
        System.out.println("=========================");
        System.out.println("the array is " + Arrays.toString(candidates));
        System.out.println("the target is [" + target + "]");
        System.out.println("\nthe combination is ");
        System.out.println(resList);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> resList = new HashSet<>();
        Arrays.sort(candidates);
        for (int index = 0; index < candidates.length; index++) {
            recursion(0, target, index, candidates, new ArrayList(), resList);
        }
        return new ArrayList<>(resList);
    }

    public static void recursion(int sum, int target, int index, int[] arr, ArrayList list, HashSet<List<Integer>> resList) {
        sum += arr[index];
        list.add(arr[index]);

        if (sum == target) {
            resList.add(new ArrayList(list));
        }

        if (sum < target) {
            for (int i = index+1; i < arr.length; i++) {
                recursion(sum, target, i, arr, list, resList);
            }
        }
        list.remove(list.size() - 1);
        return;
    }
}
