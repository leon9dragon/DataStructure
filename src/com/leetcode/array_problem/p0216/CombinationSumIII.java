package com.leetcode.array_problem.p0216;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k = 9;
        int n = 48;

        List<List<Integer>> arrayList = new CombinationSumIII().combinationSum3(k, n);

        System.out.println(arrayList);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        //45 is the sum of 1~9, no need to continue is n >49
        if (n > 45) return res;

        //Start recursion, here is the first num to add
        for (int i = 1; i < 10; i++) {
            if (10 - i >= k) {
                recursion(i, n, k, 0, new Stack(), res);
            } else break;
        }

        return res;
    }

    public static void recursion(int cur, int n, int k, int sum, Stack stack, List res) {
        //add the current number to sum and stack
        sum += cur;
        stack.push(cur);

        //the exit of the recursion is the size of stack equaled to k
        //the recursion should be ended whether the sum is right
        if (sum == n) {
            if (stack.size() == k) {
                List<Integer> list = new ArrayList<Integer>(stack);
                res.add(list);
            }
        } else if (sum < n) {
            for (int i = cur + 1; i < 10; i++) {
                if (stack.size() == k) break;
                recursion(i, n, k, sum, stack, res);
            }
        }

        //backtrack
        stack.pop();
    }
}
