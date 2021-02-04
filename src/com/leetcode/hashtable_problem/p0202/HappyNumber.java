package com.leetcode.hashtable_problem.p0202;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 2;
        System.out.printf("The result of if [%d] is happy number is [%s]", n, new HappyNumber().isHappy(n));
    }

    public boolean isHappy(int n) {
        int pro_sum = n;
        Set<Integer> res = new HashSet<>();
        while (true) {
            if (!res.contains(pro_sum)) {
                System.out.println(pro_sum);
                res.add(pro_sum);
            } else {
                if (pro_sum == 1) return true;
                else return false;
            }
            pro_sum = getProductSum(pro_sum);
        }
    }

    public int getProductSum(int n) {
        int pro_sum = 0;
        while (n != 0) {
            pro_sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return pro_sum;
    }
}
