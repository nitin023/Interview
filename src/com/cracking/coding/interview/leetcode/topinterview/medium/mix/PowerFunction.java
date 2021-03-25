package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

/**
 * https://leetcode.com/problems/powx-n/
 * Medium
 * Solved using recursion
 * and simple trick
 * X -> x/2 * x/2
 * log(n) complexity
 */
public class PowerFunction {

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / getPow(x, n);
        }
        return getPow(x, n);
    }

    private double getPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double powerResult = getPow(x, n / 2);
        if (n % 2 == 0) {
            return powerResult * powerResult;
        } else
            return x * powerResult * powerResult;
    }
}
