package com.leetcode.array_problem.p0078;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Subsets {
    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1,2,2});
        System.out.println(res);

    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> rslt = new ArrayList<List<Integer>>();
        for (int i = n; i > 0; i--) {
            dfs(new Stack<Integer>(), 0, n, i, rslt, nums);
        }
        rslt.add(new ArrayList<>());
        return rslt;
    }

    private static void dfs(Stack<Integer> path, int index, int n, int k, List<List<Integer>> rslt, int[] nums) {
        // ending case
        if (k == 0) {
            List<Integer> list = new ArrayList<Integer>(path);
            rslt.add(list);
            return;
        }
        // recursion case
        for (int i = index; i < n; i++) {
            path.push(nums[i]);
            dfs(path, i + 1, n, k - 1, rslt, nums);
            path.pop();
        }
    }
}
