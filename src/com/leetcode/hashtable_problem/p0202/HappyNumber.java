package com.leetcode.hashtable_problem.p0202;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 1;
        System.out.printf("The result of if [%d] is happy number is [%s]", n, isHappy(n));
    }

    public static boolean isHappy(int n) {
        int pro_sum = n;
        List<Integer> digits;
        Set<Integer> res = new HashSet<>();
        while (true) {
            if (!res.contains(pro_sum)) {
                System.out.println(pro_sum);
                res.add(pro_sum);
            }
            else {
                if (pro_sum == 1) return true;
                else return false;
            }
            digits = new HappyNumber().getDigits(pro_sum);
            pro_sum = new HappyNumber().getProductSum(digits);
        }
    }

    public List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    public int getProductSum(List<Integer> digits) {
        int sum = 0;
        for (int i = 0; i < digits.size(); i++) {
            sum += digits.get(i) * digits.get(i);
        }
        return sum;
    }
}
