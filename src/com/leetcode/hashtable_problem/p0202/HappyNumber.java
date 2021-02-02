package com.leetcode.hashtable_problem.p0202;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        int add = n;
        List<Integer> digits = new ArrayList<>();
        Set<Integer> res = new HashSet<>();
        int temp;
        while (true){
            res.add(add);
            digits = getDigits(n);
        }
    }

    public List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n == 0) {
            digits.add(n % 10);
            n %= 10;
        }
        return digits;
    }
}
