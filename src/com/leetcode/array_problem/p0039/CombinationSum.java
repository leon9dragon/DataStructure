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
        Set hashSet = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            hashSet.add(candidates[i]);
        }
        Set<List<Integer>> resList = new HashSet<>();
        int remainder, round;
        for (int index = 0; index < candidates.length; index++) {
            remainder = target;
            round = 0;
            while (remainder >= 0) {

                

                remainder -= candidates[index];
            }
        }

        return new ArrayList<>(resList);
    }
}
