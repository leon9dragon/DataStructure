package com.leetcode.hashtable_problem.p0204;

public class CountPrimes {
    public static void main(String[] args) {
        int n = 12;
        System.out.printf("There are [%d] prime numbers less than [%d]", new CountPrimes().countPrimes(n), n);
    }

    public int countPrimes(int n) {
        if (n == 0 || n == 1) return 0;
        int ret = 0;
        int temp, j;
        for (int i = 2; i < n; i++) {
            temp = (int) Math.sqrt(i);
            j = 2;
            while (j <= temp) {
                if (i % j == 0) break;
                j++;
            }
            if (j > temp) {
                ret++;
            }
        }
        return ret;
    }
}
