package com.leetcode.array_problem.p0509;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 6;
        System.out.printf("The result of n == [%d] is [%d]", n, fib(n));

    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) fib[i] = fib[i - 1] + fib[i - 2];
        return fib[n];

        //        List<Integer> fib = new ArrayList<>();
        //        fib.add(0);
        //        fib.add(1);
        //
        //        for (int i = 2; i <= n; i++) {
        //            fib.add(fib.get(i - 1) + fib.get(i - 2));
        //        }
        //
        //        return fib.get(n);
    }
}
